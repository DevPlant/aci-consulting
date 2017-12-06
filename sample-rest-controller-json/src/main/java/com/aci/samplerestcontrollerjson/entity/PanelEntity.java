package com.aci.samplerestcontrollerjson.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class PanelEntity {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String border;

    @JsonIgnore
    @ManyToOne
    private SectionEntity section;

    @OneToMany(mappedBy = "panel")
    private List<FieldEntity> fields = new ArrayList<>();
}
