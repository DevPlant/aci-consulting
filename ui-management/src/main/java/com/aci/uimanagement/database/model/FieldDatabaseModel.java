package com.aci.uimanagement.database.model;

import com.aci.uimanagement.model.types.FieldRendererType;
import com.aci.uimanagement.model.types.FieldType;

import lombok.Data;

@Data
public class FieldDatabaseModel extends ViewElementDatabaseModel{

    public final static String TABLE_NAME = "field_element";

    public final static String VIEW_ELEMENT_ID_COLUMN = "field_id";

    private long viewElementId;

    private String width;
    private FieldType fieldType;
    private FieldRendererType fieldRendererType;
    protected String name;
    protected String labelTranslationKey;

}
