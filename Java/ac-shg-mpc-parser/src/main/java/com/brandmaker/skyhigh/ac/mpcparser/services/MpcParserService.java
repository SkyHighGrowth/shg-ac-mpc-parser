package com.brandmaker.skyhigh.ac.mpcparser.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.shg.bmapi.constants.FieldNameConstants;
import com.shg.bmapi.enums.InheritFromParentEnum;
import com.shg.bmapi.models.jobmanager.*;
import com.shg.bmapi.models.jobmanager.metadata.MetadataTypeValueDTO;
import com.shg.bmapi.models.jobmanager.metadata.MetadataTypeValueDTOCollection;
import com.shg.bmapi.services.AuthorizationService;
import com.shg.bmapi.services.JobManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class MpcParserService {
    private final JobManagerService jobManagerService;
    private final AuthorizationService authorizationService;
    private static Map<Integer, String> createdGridsMap = new HashMap<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(MpcParserService.class);
    private final ObjectMapper objectMapper;
    private final LoggerService loggerService;


    public MpcParserService(JobManagerService jobManagerService, AuthorizationService authorizationService, ObjectMapper objectMapper, LoggerService loggerService) {
        this.jobManagerService = jobManagerService;
        this.authorizationService = authorizationService;
        this.objectMapper = objectMapper;
        this.loggerService = loggerService;
        loggerService.setFilename("C:\\GitHub\\elc-csco-sync\\Java\\elc-csco-sync\\src\\main\\resources\\csv files\\AC_MPC_Projects_Output_File");
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void initiateParserService() {

        try {
            authorizationService.initializeAuthorization();
            Map<String, ArrayList<String>> headersMap = new HashMap<>(Objects.requireNonNull(readAndMapCsvHeaders("C:\\GitHub\\elc-csco-sync\\Java\\elc-csco-sync\\src\\main\\resources\\csv files\\AC_MPC_Projects.csv")));
            Map<String, String> customObjectsMap = new HashMap<>(createMapFromCSV("C:\\GitHub\\elc-csco-sync\\Java\\elc-csco-sync\\src\\main\\resources\\csv files\\AC_CustomStructures_2023-04-26.csv"));
            Map<Integer, String> fieldImoIdMap = new HashMap<>(transformCsvFile("C:\\GitHub\\elc-csco-sync\\Java\\elc-csco-sync\\src\\main\\resources\\csv files\\AC_uap_projects_csv.csv", "C:\\GitHub\\elc-csco-sync\\Java\\elc-csco-sync\\src\\main\\resources\\csv files\\AC_uap_projects_csv_transformed.csv"));
            updateMpcObjects("C:\\GitHub\\elc-csco-sync\\Java\\elc-csco-sync\\src\\main\\resources\\csv files\\AC_uap_projects_csv_transformed.csv", headersMap, customObjectsMap, fieldImoIdMap);
        } catch (CsvException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    private boolean updateMpcObjects(String inputFile, Map<String, ArrayList<String>> headersMap, Map<String, String> customObjectsMap, Map<Integer, String> fieldImoIdMap) {
        try {
            CSVReader reader = new CSVReader(new FileReader(inputFile));
            String[] header = reader.readNext();
            int pos = 0;
            String[] mpc;

            while ((mpc = reader.readNext()) != null) {
                // Process the current row

                findThenUpdateMpcObject(mpc, headersMap, pos, customObjectsMap, fieldImoIdMap);
                pos++;
            }

        } catch (IOException | CsvValidationException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }

        return false;
    }

    private String createValueWithEscChar(String value) {
        char additionalChar = '"';
        String helper = additionalChar + value;

        return new StringBuilder(helper).insert(helper.length(), additionalChar).toString();

    }

    private String createValueStrForDataTypeUser(String nameValue, Integer idValue, String loginValue) {
        String name = "\"name\"" + ":" + createValueWithEscChar(nameValue);
        String id = "\"id\"" + ":" + idValue;
        String login = "\"login\"" + ":" + createValueWithEscChar(loginValue);
        String fullValue = "{" + name + "," + id + "," + login + "}";

        return fullValue;

    }

    private String getMpcValueFromCustomStructure(Map<String, ArrayList<String>> headersLookupMap, int pos, String mpcLineDao, Map<String, String> customObjectsMap) {
        String coMapKey = headersLookupMap.get("BM CS Name").get(pos);
        MetadataTypeValueDTOCollection bMCustomStructure = jobManagerService.getCustomStructureValuesByName(coMapKey);
        List<MetadataTypeValueDTO> bMCustomStructureValues = bMCustomStructure.getData();
        for (MetadataTypeValueDTO customStrValue : bMCustomStructureValues
        ) {
            if (customStrValue.getLabel().get_default().equals(mpcLineDao)) {
                coMapKey = coMapKey + "-" + "{\"default\":" + createValueWithEscChar(mpcLineDao) + "}";
                return customObjectsMap.get(coMapKey);
            }
        }
        return null;
    }

    private boolean findThenUpdateMpcObject(String[] mpcLineDao, Map<String, ArrayList<String>> headersLookupMap, int pos, Map<String, String> customObjectsMap, Map<Integer, String> fieldImoIdMap) {


        //find old job
        SearchParamsDTO searchParamsDTO = new SearchParamsDTO();
        SearchVariableConditionDTO searchVariableConditionMpcJobs = new SearchVariableConditionDTO();
        searchVariableConditionMpcJobs.setValue(FieldNameConstants.MPCJOBTYPEID); //TODO GET VALUE THROUGH API CALL
        searchVariableConditionMpcJobs.setName("job__type__pseudo__variable");
        searchVariableConditionMpcJobs.setCmpCondition("EQUAL");
        searchVariableConditionMpcJobs.setOperator("AND");

        SearchVariableConditionDTO searchVariableConditionMpcJobImoAttribute = new SearchVariableConditionDTO();
        String imoAttributeValue=headersLookupMap.get("IMO Attribute").get(pos);
        searchVariableConditionMpcJobImoAttribute.setValue(imoAttributeValue);
        //searchVariableConditionMpcJobImoAttribute.setValue("313");
        searchVariableConditionMpcJobImoAttribute.setName("imo_system_id");
        searchVariableConditionMpcJobImoAttribute.setCmpCondition("EQUAL");
        searchVariableConditionMpcJobImoAttribute.setOperator("AND");
        searchVariableConditionMpcJobImoAttribute.setJobTypeUniqueName("marketing_point_code");
        List<SearchVariableConditionDTO> paramsList = new ArrayList<>();
        paramsList.add(searchVariableConditionMpcJobs);
        paramsList.add(searchVariableConditionMpcJobImoAttribute);
        searchParamsDTO.setVariableCondition(paramsList);


        // get all MPC Jobs on system
        List<JobDTO> mpcJobResultList = jobManagerService.findJobBySearchParams(searchParamsDTO);
        JobDTO mpcOldJob = mpcJobResultList.get(0);

        //check if field is part of some grid
        int gridUpdateFlag = 0;
        Integer jobsGridRowVariableInstanceId = findJobsGridRowVariableInstanceId(headersLookupMap.get("BM Tech Name").get(pos));
        if (jobsGridRowVariableInstanceId != null) {
            gridUpdateFlag = 1;
            Collection<GridRowDto> gridRows = jobManagerService.getGridRowsByJobOrdinalIdAndVariableInstanceId(mpcOldJob.getOrdinalNumber(), jobsGridRowVariableInstanceId);
            List<GridRowDto> gridRowsList = new ArrayList<>(gridRows);
            if (gridRowsList.isEmpty()) // is empty
            {
                // create grid
                GridRowUpdateDto gridRowUpdateDto = new GridRowUpdateDto();
                Map<String, String> values = new HashMap<>();
                values.put(headersLookupMap.get("BM Tech Name").get(pos), createValueWithEscChar(mpcLineDao[pos]));
                gridRowUpdateDto.setValues(values);
                String json = null;
                try {
                    json = this.objectMapper.writeValueAsString(values);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(json);
                GridRowDto gridRowDto = jobManagerService.createNewGridRowByJobOrdinalIdAndVariableInstanceId(json, mpcOldJob.getOrdinalNumber(), jobsGridRowVariableInstanceId);
                System.out.println(gridRowDto);
                return true;
            } else {
                // update grid row
                GridRowUpdateDto gridRowUpdateDto = new GridRowUpdateDto();
                Map<String, String> values = new HashMap<>();
                values.put(headersLookupMap.get("BM Tech Name").get(pos), createValueWithEscChar("2023-05-16"));
                String json = null;
                gridRowUpdateDto.setValues(values);
                try {
                    json = this.objectMapper.writeValueAsString(values);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(json);
                json = "{\"values\":" + json + "}";
                System.out.println(json);

                if (jobManagerService.updateGridRowByJobOrdinalIdAndVariableInstanceIdAndRowId(json, mpcOldJob.getOrdinalNumber(), jobsGridRowVariableInstanceId, gridRowsList.get(0).getRowInstanceId())) {
                    System.out.print("Grid row update successful");

                }
                return true;
            }
        }


        //if not GridTypeVariable
        List<DseObjectUpdateValueDto> dseObjectUpdateValueDtos = new ArrayList<>();
        DseObjectUpdateValueDto updateValueDto = new DseObjectUpdateValueDto();
        //updateValueDto.setValue(createValueWithEscChar("2023-02-20"));
        updateValueDto.setTechnicalName(headersLookupMap.get("BM Tech Name").get(pos));
        updateValueDto.setInheritFromParent(InheritFromParentEnum.NOT_SUPPORTED);
        DseObjectUpdateDto dseObjectUpdateDto = new DseObjectUpdateDto();
        dseObjectUpdateDto.setInstanceId(mpcOldJob.getInstanceId());
        dseObjectUpdateDto.setL10nLocaleId(0);
        dseObjectUpdateDto.setStepNumber(0);


        // Switch based on BM Data Type values
        int userFlag = 0;
        String bmDataType = headersLookupMap.get("BM Data Type").get(pos);
        String newValue = "";

        if (bmDataType.equals("USER")) {
            return false;
        }

        switch (bmDataType.trim().toUpperCase()) {
            case "SINGLESELECT":
            case "MULTISELECT":
                if (getMpcValueFromCustomStructure(headersLookupMap, pos, mpcLineDao[pos], customObjectsMap) != null) {
                    newValue = getMpcValueFromCustomStructure(headersLookupMap, pos, mpcLineDao[pos], customObjectsMap);
                    updateValueDto.setValue(newValue);
                    LOGGER.info("UPDATE FROM CS SUCCESSFUL!");
                } else {
                    LOGGER.error("UPDATE FROM CS UNSUCCESSFUL!");

                }
                break;
            case "MULTIINPUTLINE":
            case "NUMBERS":
            case "SINGLEINPUTLINE":
            case "DATEPICKER":
            case "MULTILINEINPUTAREA":
                newValue = createValueWithEscChar(mpcLineDao[pos]);
                updateValueDto.setValue(newValue);
                break;
            case "USER":
                userFlag = 1;
                break;
        }
        if (userFlag == 1) {
            return false;
        }

        dseObjectUpdateValueDtos.add(updateValueDto);
        dseObjectUpdateDto.setValues(dseObjectUpdateValueDtos);
        System.out.println(new Gson().toJson(dseObjectUpdateDto));
        DseObjectDto updatedJob = jobManagerService.updateJob(dseObjectUpdateDto);
        System.out.println(new Gson().toJson(updatedJob));
        loggerService.log(mpcLineDao[pos]);

        return true;
    }


    private Integer findJobsGridRowVariableInstanceId(String techName) {
        DseObjectTypeDto dseObjectTypeDto = jobManagerService.getDseObjectTypesByJobTypeId(2521);
        List<BaseVariableTypeDto> dseObjectTypeVariables = dseObjectTypeDto.getVariables();
        for (int i = 0; i < dseObjectTypeVariables.size(); i++) {
            if (dseObjectTypeVariables.get(i).getMetaTypeName().equals("GridVariableType")) {

                for (ComfortGridColumnRestDto gridColumn : dseObjectTypeVariables.get(i).getColumns()
                ) {
                    if (gridColumn.getTechnicalName().equals(techName)) {
                        return gridColumn.getId();
                    }
                }
            }
        }
        return null;
    }

    private Map<String, ArrayList<String>> readAndMapCsvHeaders(String originalFilePath) {
        Map<String, ArrayList<String>> headersMap = new HashMap<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(originalFilePath));
            int numberOfRowsToRead = 6;

            String[] nextLine;
            int rowCount = 0;

            while ((nextLine = reader.readNext()) != null && rowCount < numberOfRowsToRead) {
                // Process the current row
                String keyValue = null;
                ArrayList<String> values = new ArrayList<>();
                for (int i = 0; i < nextLine.length; i++) {
                    if (i == 0) {
                        keyValue = nextLine[i];
                    } else {
                        values.add(nextLine[i]);
                    }
                }
                System.out.println();

                rowCount++;
                headersMap.put(keyValue, values);
            }

            return headersMap;
        } catch (IOException | CsvValidationException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }

    }

    private Map<Integer, String> transformCsvFile(String inputFile, String outputFile) throws IOException, CsvException {
        int rowsToSkip = 7;
        Map<Integer, String> headerMap = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            // Skip the specified number of rows
            for (int i = 0; i < rowsToSkip; i++) {
                reader.readNext();
            }

            // Read the remaining rows, trim the first column, and create the modified data and header map
            String[] nextLine;
            List<String[]> modifiedData = new ArrayList<>();
            int rowIndex = 0;

            while ((nextLine = reader.readNext()) != null) {
                String[] modifiedRow = new String[nextLine.length - 1];
                System.arraycopy(nextLine, 1, modifiedRow, 0, nextLine.length - 1);
                modifiedData.add(modifiedRow);

                headerMap.put(rowIndex, nextLine[1]); // Store position and value in headerMap
                rowIndex++;
            }

            // Write the modified data (without the first column) to the new file
            writer.writeAll(modifiedData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Trim the first column from the output file
        trimFirstColumn(outputFile);

        return headerMap;
    }

    private void trimFirstColumn(String outputFile) {
        List<String[]> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(outputFile))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String[] modifiedRow = new String[nextLine.length - 1];
                System.arraycopy(nextLine, 1, modifiedRow, 0, nextLine.length - 1);
                data.add(modifiedRow);
            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            writer.writeAll(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Map<String, String> createMapFromCSV(String csvFilePath) {
        Map<String, String> map = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;

            while ((line = reader.readNext()) != null) {
                if (line.length >= 3) {
                    String key = line[0] + "-" + line[2];
                    String value = line[1];
                    map.put(key, value);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return map;
    }
}
