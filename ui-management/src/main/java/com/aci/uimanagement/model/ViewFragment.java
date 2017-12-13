package com.aci.uimanagement.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aci.uimanagement.model.common.AbstractViewElement;
import com.aci.uimanagement.model.types.LayoutType;

import lombok.Data;

@Data
public class ViewFragment {

    private long id;
    private String name;

    private LayoutType layoutType;
    private List<AbstractViewElement> children = new ArrayList<>();

    public void sortChildren() {
        Collections.sort(children);
        for (AbstractViewElement child : children) {
            child.sortChildren();
        }
    }

}
