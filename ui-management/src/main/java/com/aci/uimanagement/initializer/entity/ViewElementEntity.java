package com.aci.uimanagement.initializer.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.aci.uimanagement.model.types.ElementType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "VIEW_ELEMENT")
@EqualsAndHashCode(of = "id")
public class ViewElementEntity {

    @Id
    @Column(name = "view_element_id")
    @GeneratedValue
    protected long id;

    @Enumerated(EnumType.STRING)
    protected ElementType elementType;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TabEntity tabEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TabGroupEntity tabGroupEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AccordionEntity accordionEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AccordionGroupEntity accordionGroupEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PanelEntity panelEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FieldEntity fieldEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private GridEntity gridEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DataGridEntity dataGridEntity;

}
