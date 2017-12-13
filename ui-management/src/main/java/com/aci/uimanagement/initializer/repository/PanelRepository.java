package com.aci.uimanagement.initializer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aci.uimanagement.initializer.entity.PanelEntity;

/**
 *
 */
public interface PanelRepository extends JpaRepository<PanelEntity,Long> {
}
