package com.aci.uimanagement.database.model;

import com.aci.uimanagement.model.types.ElementType;
import com.aci.uimanagement.model.types.OverrideType;

import lombok.Data;

@Data
public class OverrideElementDatabaseModel {

    public final static String TABLE_NAME = "override_element";
    public final static String VIEW_FRAGMENT_ID_COLUMN = "view_fragment_id";
    public final static String ID_COLUMN = "id";

    private long id;
    private long elementId;
    private long viewFragmentId;
    private ElementType elementType;
    private OverrideType overrideType;

}
