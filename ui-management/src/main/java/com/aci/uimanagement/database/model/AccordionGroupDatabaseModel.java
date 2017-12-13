package com.aci.uimanagement.database.model;

import lombok.Data;

@Data
public class AccordionGroupDatabaseModel extends ViewElementDatabaseModel {

    public final static String TABLE_NAME = "accordion_group_element";

    public final static String VIEW_ELEMENT_ID_COLUMN = "accordion_group_id";

    private long viewElementId;

}
