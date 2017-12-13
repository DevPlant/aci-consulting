package com.aci.uimanagement.initializer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PANEL_ELEMENT")
public class PanelEntity {


    @Id
    @Column(unique = true, nullable = false, name = "panel_id")
    private Long id;

    protected String angularComponentName;

    @MapsId
    @OneToOne
    @JoinColumn(name = "panel_id")
    private ViewElementEntity viewElement;

}
