package com.aci.uimanagement.initializer.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aci.uimanagement.model.types.PropertyType;

import lombok.Data;

@Data
@Entity
@Table(name = "OVERRIDE_ELEMENT_VALUE")
public class OverrideElementValueEntity {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    private String value;

    @ManyToOne
    @JoinColumn(name = "override_element_id")
    private OverrideElementEntity overrideElement;
}
