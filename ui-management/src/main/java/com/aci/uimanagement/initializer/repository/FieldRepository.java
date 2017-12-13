package com.aci.uimanagement.initializer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aci.uimanagement.initializer.entity.FieldEntity;

/**
 *
 */
public interface FieldRepository extends JpaRepository<FieldEntity,Long> {
}
