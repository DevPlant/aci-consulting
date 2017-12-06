package com.aci.samplerestcontrollerjson.exception;

public class AciObjectNotFoundException extends  RuntimeException {

    public AciObjectNotFoundException(String message){
        super(message);
    }
}
