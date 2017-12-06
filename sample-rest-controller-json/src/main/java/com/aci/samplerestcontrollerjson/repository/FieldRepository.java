package com.aci.samplerestcontrollerjson.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aci.samplerestcontrollerjson.entity.FieldEntity;

public interface FieldRepository extends JpaRepository<FieldEntity, Long> {
}
