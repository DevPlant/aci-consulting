package com.aci.uimanagement.controller;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aci.uimanagement.model.ViewFragment;
import com.aci.uimanagement.service.ViewDataReadService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ViewController {


    @Autowired
    private ViewDataReadService viewDataReadService;

    @GetMapping("/view")
    public ViewFragment getViewFragment(@RequestParam("viewName") String viewName) throws InvocationTargetException, IllegalAccessException, SQLException, InstantiationException {
        return viewDataReadService.readView(viewName);
    }

}
