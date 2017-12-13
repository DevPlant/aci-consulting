package com.aci.uimanagement.database.model;

import com.aci.uimanagement.model.types.LayoutType;

import lombok.Data;

@Data
public class ViewFragmentDatabaseModel {

    public final static String TABLE_NAME = "view_fragment";
    public final static String NAME_COLUMN = "name";

    private long id;

    private String name;

    private LayoutType layoutType;

}
