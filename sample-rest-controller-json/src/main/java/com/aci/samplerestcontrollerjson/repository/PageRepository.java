package com.aci.samplerestcontrollerjson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aci.samplerestcontrollerjson.entity.PageEntity;

public interface PageRepository extends JpaRepository<PageEntity, Long> {

    PageEntity findByName(String name);

    @Query("Select p from PageEntity p where p.name = ?1")
    PageEntity findByNameUsingJPAQuery(String name);

}
