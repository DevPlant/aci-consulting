package com.aci.uimanagement.initializer.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aci.uimanagement.model.types.ElementType;
import com.aci.uimanagement.model.types.OverrideType;

import lombok.Data;

@Entity
@Data
@Table(name = "OVERRIDE_ELEMENT")
public class OverrideElementEntity {

    @Id
    @GeneratedValue
    private long id;

    private long elementId;

    @ManyToOne
    private ViewFragmentEntity viewFragment;

    @Enumerated(EnumType.STRING)
    private ElementType elementType;

    @Enumerated(EnumType.STRING)
    private OverrideType overrideType;

    @OneToMany(mappedBy = "overrideElement")
    private List<OverrideElementValueEntity> overrideElementValues;

}
