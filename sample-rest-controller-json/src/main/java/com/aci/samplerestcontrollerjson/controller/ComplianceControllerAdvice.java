package com.aci.samplerestcontrollerjson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aci.samplerestcontrollerjson.exception.AciObjectNotFoundException;
import com.aci.samplerestcontrollerjson.model.ErrorModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ComplianceControllerAdvice {

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(value = {AciObjectNotFoundException.class})
    public ErrorModel handleAbonnementCanceledException(AciObjectNotFoundException exception) {
        log.debug(exception.getMessage(), exception);
        return new ErrorModel(exception.getMessage());
    }

}