package com.aci.uimanagement.model.elements;

import com.aci.uimanagement.model.common.AbstractViewElement;
import com.aci.uimanagement.model.types.FieldType;

import lombok.Data;

@Data
public class Field extends AbstractViewElement {

    private String width;
    private String name;
    private String labelTranslationKey;
    private FieldType fieldType;
}
