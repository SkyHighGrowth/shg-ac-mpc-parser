package com.brandmaker.skyhigh.ac.mpcparser.services;


import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class LoggerService {
    private String filename;

    public LoggerService(){

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
}
