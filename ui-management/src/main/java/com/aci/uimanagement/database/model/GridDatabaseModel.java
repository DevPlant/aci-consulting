package com.aci.uimanagement.database.model;

import lombok.Data;

@Data
public class GridDatabaseModel extends ViewElementDatabaseModel{

    public final static String TABLE_NAME = "grid_element";

    public final static String VIEW_ELEMENT_ID_COLUMN = "grid_id";

    private long viewElementId;
    protected String dataUrl;
    protected String name;
    protected String labelTranslationKey;
    protected long columnCount;
}
