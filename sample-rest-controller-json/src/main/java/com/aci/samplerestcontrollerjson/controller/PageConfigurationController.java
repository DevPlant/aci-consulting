package com.aci.samplerestcontrollerjson.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aci.samplerestcontrollerjson.entity.PageEntity;
import com.aci.samplerestcontrollerjson.exception.AciObjectNotFoundException;
import com.aci.samplerestcontrollerjson.repository.PageRepository;

@RestController
@RequestMapping("/api")
public class PageConfigurationController {

    @Autowired
    private PageRepository pageRepository;


    @GetMapping("/page/{pageId}")
    public PageEntity getPageMapping(@PathVariable("pageId") long pageId) {

        PageEntity pageEntity = pageRepository.findOne(pageId);
        if (pageEntity == null) {
            throw new AciObjectNotFoundException("Page with id " + pageId + " does not exist!");
        }
        return pageEntity;
    }


    @GetMapping("/page")
    public PageEntity getPageMappingByName(@RequestParam("pageName") String name) {
        PageEntity pageEntity = pageRepository.findByName(name);
        if (pageEntity == null) {
            throw new AciObjectNotFoundException("Page with name " + name + " does not exist!");
        }
        return pageEntity;
    }


}
