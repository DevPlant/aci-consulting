package com.aci.uimanagement.database.model;

import lombok.Data;

@Data
public class LinkageDatabaseModel {

    public final static String TABLE_NAME =  "element_links";

    public final static String VIEW_FRAGMENT_ID_COLUMN = "view_fragment_id";

    private long id;

    private long viewFragmentId;

    private Long viewElementId;
    private Long viewElementParentId;

}
