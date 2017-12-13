package com.aci.uimanagement.service;

import org.springframework.stereotype.Service;

@Service
public class SqlService {

    public String createSelectAllStatement(String tableName) {
        return "SELECT * FROM " + tableName;
    }



}
