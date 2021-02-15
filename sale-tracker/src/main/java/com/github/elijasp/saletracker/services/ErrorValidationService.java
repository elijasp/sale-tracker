package com.github.elijasp.saletracker.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Service
public class ErrorValidationService {
    public ResponseEntity<?> validateErrors(BindingResult result){
        if (result.hasErrors()) {
            // structure response {"field" : "defaultMessage"}
            Map<String, String> validationErrors = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                validationErrors.put(err.getField(), err.getDefaultMessage());
            });

            return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
