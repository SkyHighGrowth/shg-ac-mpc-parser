package com.shg.bmapi.services;

import com.shg.bmapi.configurations.properties.ConfigProperties;
import com.shg.bmapi.constants.DseEndPointConstants;
import com.shg.bmapi.models.TransactionLogsDTO;
import com.shg.bmapi.utils.HttpUtils;
import com.shg.bmapi.utils.JobUtils;
import com.shg.bmapi.utils.RestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionsLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsLogService.class);
    private final RestTemplate restTemplate;
    private final ConfigProperties properties;

    public TransactionsLogService(RestTemplate restTemplate, ConfigProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    public ResponseEntity<Object> AddTransactionLogs(TransactionLogsDTO transactionLogsDTO)
    {
        try {
            final MultiValueMap<Object, Object> params = JobUtils.mapAddTransaction(transactionLogsDTO);

            final ResponseEntity<Object> responseBody = RestUtils.sendPostRequestREO(
                    restTemplate,
                    MediaType.APPLICATION_JSON,
                    HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.REST_1_ADD_TRANSACTION)),
                    params.toSingleValueMap()
            );

            return responseBody;//this.objectMapper.convertValue(responseBody, JobDTO.class);
        }
        catch (Exception ex)
        {
            LOGGER.error("Failed to write to transaction logs service");
            LOGGER.error(ex.getMessage(),ex);
            return  null;
        }
        //return null;
    }

//    public ResponseEntity<Object> AddBulkTransactionLogs(List<TransactionLogsDTO> transactionLogsDTOS)
//    {
//        final MultiValueMap<Object, Object> params = JobUtils.mapAddTransaction(transactionLogsDTO);
//
//        final ResponseEntity<Object> responseBody = RestUtils.sendPostRequestREO(
//                restTemplate,
//                MediaType.APPLICATION_JSON,
//                HttpUtils.createUrl(properties.getUrl(), String.format(DseEndPointConstants.REST_1_ADD_TRANSACTION)),
//                params.toSingleValueMap()
//        );
//
//        return responseBody;//this.objectMapper.convertValue(responseBody, JobDTO.class);
//    }
}
