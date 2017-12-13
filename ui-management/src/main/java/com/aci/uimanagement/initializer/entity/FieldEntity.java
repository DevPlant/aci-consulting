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

import com.aci.uimanagement.model.types.FieldType;

import lombok.Data;

@Data
@Entity
@Table(name = "FIELD_ELEMENT")
public class FieldEntity {

    @Id
    @Column(unique = true, nullable = false, name = "field_id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "field_id")
    private ViewElementEntity viewElement;

    private String width;
    protected String name;
    protected String labelTranslationKey;

    @Enumerated(EnumType.STRING)
    private FieldType fieldType;

}
