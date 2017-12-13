package com.aci.uimanagement.database.model;


import com.aci.uimanagement.model.types.ElementType;
import com.aci.uimanagement.model.types.OverrideType;
import com.aci.uimanagement.model.types.PropertyType;

import lombok.Data;

@Data
public class OverrideElementValueViewDatabaseModel implements Comparable<OverrideElementValueViewDatabaseModel> {

    public final static String TABLE_NAME = "override_element_value";
    public final static String OVERRIDE_ELEMENT_ID_COLUMN = "override_element_id";

    private long elementId;
    private long viewFragmentId;
    private ElementType elementType;
    private OverrideType overrideType;
    private PropertyType propertyType;
    private String value;

    public void updateProperty(Object target) {
        if(target!=null) {
            propertyType.setProperty(target, value);
        }
    }

    @Override
    public int compareTo(OverrideElementValueViewDatabaseModel o) {
        return this.overrideType.compareTo(o.overrideType);
    }
}
