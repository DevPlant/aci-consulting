package com.aci.uimanagement.database.model;

import lombok.Data;

@Data
public class PanelDatabaseModel extends ViewElementDatabaseModel{

    public final static String TABLE_NAME = "panel_element";

    public final static String VIEW_ELEMENT_ID_COLUMN = "panel_id";

    private long viewElementId;
    private String angularComponentName;

}
