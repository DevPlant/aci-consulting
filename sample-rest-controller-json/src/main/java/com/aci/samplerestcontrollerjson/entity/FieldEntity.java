package com.aci.samplerestcontrollerjson.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.aci.samplerestcontrollerjson.type.FieldType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldEntity {

    @Id
    @GeneratedValue
    private long id;

    private FieldType fieldType;

    private String label;

    private String name;

    @JsonIgnore
    @ManyToOne
    private PanelEntity panel;

}
