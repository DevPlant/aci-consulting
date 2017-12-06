package com.aci.samplerestcontrollerjson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aci.samplerestcontrollerjson.entity.PanelEntity;

public interface PanelRepository extends JpaRepository<PanelEntity,Long>{
}
