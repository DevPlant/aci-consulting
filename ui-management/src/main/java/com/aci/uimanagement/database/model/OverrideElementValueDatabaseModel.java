package com.aci.uimanagement.database.model;


import com.aci.uimanagement.model.types.PropertyType;

import lombok.Data;

@Data
public class OverrideElementValueDatabaseModel {

    public final static String TABLE_NAME = "override_element_value";
    public final static String OVERRIDE_ELEMENT_ID_COLUMN = "override_element_id";

    private long id;

    private PropertyType propertyType;
    private String value;

    private long overrideElementId;

}
