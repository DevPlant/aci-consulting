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
@Table(name = AccordionGroupEntity.TABLE_NAME)
public class AccordionGroupEntity {

    public final static String TABLE_NAME = "ACCORDION_GROUP_ELEMENT";

    @Id
    @Column(unique = true, nullable = false, name = "accordion_group_id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "accordion_group_id")
    private ViewElementEntity viewElement;


}
