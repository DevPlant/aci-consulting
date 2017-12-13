package com.aci.uimanagement.database.model;

import lombok.Data;

@Data
public class DataGridDatabaseModel extends ViewElementDatabaseModel{

    public final static String TABLE_NAME = "data_grid_element";

    public final static String VIEW_ELEMENT_ID_COLUMN = "data_grid_id";

    private long viewElementId;
    protected String dataUrl;
    protected String name;
    protected String labelTranslationKey;
    protected long columnCount;
}
