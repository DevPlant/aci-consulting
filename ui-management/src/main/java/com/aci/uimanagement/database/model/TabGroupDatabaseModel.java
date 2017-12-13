package com.aci.uimanagement.database.model;

import lombok.Data;

@Data
public class TabGroupDatabaseModel extends ViewElementDatabaseModel {

    public final static String TABLE_NAME = "tab_group_element";

    public final static String VIEW_ELEMENT_ID_COLUMN = "tab_group_id";

    private long viewElementId;

}
