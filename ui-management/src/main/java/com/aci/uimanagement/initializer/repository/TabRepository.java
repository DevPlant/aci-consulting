package com.aci.uimanagement.initializer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aci.uimanagement.initializer.entity.TabEntity;

/**
 *
 */
public interface TabRepository extends JpaRepository<TabEntity,Long> {
}
