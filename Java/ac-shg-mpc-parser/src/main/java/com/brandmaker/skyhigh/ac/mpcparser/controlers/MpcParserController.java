package com.brandmaker.skyhigh.ac.mpcparser.controlers;


import com.brandmaker.skyhigh.ac.mpcparser.services.MpcParserService;
import com.shg.bmapi.services.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;



@RestController
public class MpcParserController {
    private final MpcParserService mpcParserService;

    public MpcParserController(MpcParserService mpcParserService) {
        this.mpcParserService = mpcParserService;
    }

    @PostMapping("/test")
    public ResponseEntity<String> testParserService() {
        String result = "update successful";
        mpcParserService.initiateParserService();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
