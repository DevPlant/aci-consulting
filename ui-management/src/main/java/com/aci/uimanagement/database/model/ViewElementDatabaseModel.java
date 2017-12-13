package com.aci.uimanagement.database.model;


import com.aci.uimanagement.model.types.ElementType;

import lombok.Data;

@Data
public class ViewElementDatabaseModel {

    public final static String TABLE_NAME = "view_element";

    public final static String VIEW_FRAGMENT_ID_COLUMN = "view_fragment_id";
    public static final String ID_COLUMN = "view_element_id";

    protected long id;
    protected ElementType elementType;

}
