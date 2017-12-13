package com.aci.uimanagement.initializer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.aci.uimanagement.model.types.LayoutType;

import lombok.Data;


@Data
@Entity
@Table(name = AccordionEntity.TABLE_NAME)
public class AccordionEntity {

    public final static String TABLE_NAME = "ACCORDION_ELEMENT";

    @Id
    @Column(unique = true, nullable = false, name = "accordion_id")
    private Long id;

    protected String name;
    protected String labelTranslationKey;

    @Enumerated(EnumType.STRING)
    protected LayoutType layoutType;

    @MapsId
    @OneToOne
    @JoinColumn(name = "accordion_id")
    private ViewElementEntity viewElement;

}
