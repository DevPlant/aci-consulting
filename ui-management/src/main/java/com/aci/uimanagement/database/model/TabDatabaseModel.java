package com.aci.uimanagement.database.model;

import com.aci.uimanagement.model.types.LayoutType;

import lombok.Data;

@Data
public class TabDatabaseModel extends ViewElementDatabaseModel{

    public final static String TABLE_NAME = "tab_element";

    public final static String VIEW_ELEMENT_ID_COLUMN = "tab_id";

    private long viewElementId;
    protected String name;
    protected String labelTranslationKey;
    protected LayoutType layoutType;

}
