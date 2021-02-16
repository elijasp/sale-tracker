package com.github.elijasp.saletracker.controllers;

import com.github.elijasp.saletracker.domain.Sale;
import com.github.elijasp.saletracker.services.ErrorValidationService;
import com.github.elijasp.saletracker.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class SaleController {
    // == fields ==
    private final SaleService saleService;
    private final ErrorValidationService validationService;
    // == constructor based DI ==
    @Autowired
    public SaleController(SaleService saleService, ErrorValidationService validationService) {
        this.saleService = saleService;
        this.validationService = validationService;
    }

    // == save ==
    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Sale sale, BindingResult result) {
        ResponseEntity<?> validationErrors = validationService.validateErrors(result);
        if(validationErrors == null){
            return validationErrors;
        }
        Sale savedSale = saleService.save(sale);
        return new ResponseEntity<>(savedSale, HttpStatus.OK);
    }

}
