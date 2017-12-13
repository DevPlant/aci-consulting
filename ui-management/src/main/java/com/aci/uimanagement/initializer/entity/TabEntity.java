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
@Table(name = "TAB_ELEMENT")
public class TabEntity {

    @Id
    @Column(unique = true, nullable = false, name = "tab_id")
    private Long id;

    protected String name;
    protected String labelTranslationKey;

    @Enumerated(EnumType.STRING)
    protected LayoutType layoutType;

    @MapsId
    @OneToOne
    @JoinColumn(name = "tab_id")
    private ViewElementEntity viewElement;

}
