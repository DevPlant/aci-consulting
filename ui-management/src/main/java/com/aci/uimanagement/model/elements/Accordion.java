package com.aci.uimanagement.model.elements;

import com.aci.uimanagement.model.common.AbstractViewElement;
import com.aci.uimanagement.model.types.LayoutType;

import lombok.Data;

@Data
public class Accordion extends AbstractViewElement {

    private String name;
    private String labelTranslationKey;
    private LayoutType layoutType;

}
