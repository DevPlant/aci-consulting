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
@Table(name = "GRID_ELEMENT")
public class GridEntity {

    @Id
    @Column(unique = true, nullable = false, name = "grid_id")
    private Long id;

    protected String dataUrl;
    protected String name;
    protected String labelTranslationKey;

    @MapsId
    @OneToOne
    @JoinColumn(name = "grid_id")
    private ViewElementEntity viewElement;
}
