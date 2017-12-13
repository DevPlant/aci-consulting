package com.aci.uimanagement.model.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aci.uimanagement.model.types.ElementType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "viewElementId")
public class AbstractViewElement implements Comparable<AbstractViewElement> {

    protected long viewElementId;
    protected ElementType elementType;
    private List<AbstractViewElement> children = new ArrayList<>();
    protected long elementOrder;

    public void sortChildren() {
        Collections.sort(children);
        for (AbstractViewElement child : children) {
            child.sortChildren();
        }
    }

    @Override
    public int compareTo(AbstractViewElement o) {
        return Long.compare(this.elementOrder, o.elementOrder);
    }
}
