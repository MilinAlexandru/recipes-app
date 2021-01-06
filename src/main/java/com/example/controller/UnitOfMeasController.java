package com.example.controller;


import com.example.model.UnitOfMeasurement;
import com.example.services.UnitOfMeasServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;
import java.util.logging.Logger;

@Slf4j
@RequestMapping("api")
@Controller
public class UnitOfMeasController {


    //public static final Logger log = LoggerFactory.getLogger(UnitOfMeasController.class);

    private final UnitOfMeasServiceImpl unitOfMeasService;


    public UnitOfMeasController(UnitOfMeasServiceImpl unitOfMeasService) {
        this.unitOfMeasService = unitOfMeasService;
    }


    @GetMapping("/uom")
    public ResponseEntity<Set<UnitOfMeasurement>> unitOfMeasurements() {
        Set<UnitOfMeasurement> uom = unitOfMeasService.listUom();
        return ResponseEntity.ok(uom);

    }

}
