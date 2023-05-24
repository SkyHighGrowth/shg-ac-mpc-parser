package com.brandmaker.skyhigh.ac.mpcparser.services;


import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@Service
public class LoggerService {
    private String filename;

    public LoggerService() {

    }

    public LoggerService(String filename) {
        this.filename = filename;
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void log(String string) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logMpcLineResult(String[] mpcLine, boolean success, String imoId) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true))) {
            String imoIdString=" IMO SYSTEM ID: " + imoId;
            String resultString=null;
            if (success) {
                resultString= Arrays.toString(mpcLine) +imoIdString+" UPDATE SUCCESSFUL";
            } else {
                resultString = Arrays.toString(mpcLine) + imoIdString + " UPDATE FAILED";
            }
            writer.writeNext(new String[]{resultString});



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
