package com.aci.uimanagement.model.elements;

import com.aci.uimanagement.model.common.AbstractViewElement;

import lombok.Data;

@Data
public class DataGrid extends AbstractViewElement {

    private String dataUrl;
    private String name;
    private String labelTranslationKey;
    private long columnCount;

}
