package com.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tolaf on 29/04/2018.
 *
 * Using Spring to build Automation Framework
 * Objective: Execution Entry Point and Exit Point - Similar to Hook
 */

@Component
public class BrowserContext {
    @Autowired
    private BrowserFactory browserFactory;
    @Autowired
    private BrowserEvent browserEvent;

    private BrowserUtils browserUtils;

    public void setUp(){
        this.browserUtils=browserFactory.create();
    }

    public void tearDown(){
        this.browserUtils.quit();
    }

    public BrowserUtils getBrowser(){
        return this.browserUtils;
    }
}