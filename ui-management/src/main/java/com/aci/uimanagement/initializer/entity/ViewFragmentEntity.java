package com.aci.uimanagement.initializer.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aci.uimanagement.model.types.LayoutType;

import lombok.Data;

@Data
@Entity
@Table(name= ViewFragmentEntity.TABLE_NAME)
public class ViewFragmentEntity {

    public final static String TABLE_NAME = "VIEW_FRAGMENT";

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private LayoutType layoutType;


}
