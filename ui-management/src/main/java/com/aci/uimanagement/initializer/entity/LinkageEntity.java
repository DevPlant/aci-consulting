package com.aci.uimanagement.initializer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ELEMENT_LINKS")
public class LinkageEntity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private ViewFragmentEntity viewFragment;

    @ManyToOne
    @JoinColumn(name = "view_element_id")
    private ViewElementEntity viewElement;

    @ManyToOne
    @JoinColumn(name="view_element_parent_id")
    private ViewElementEntity viewElementParent;

}
