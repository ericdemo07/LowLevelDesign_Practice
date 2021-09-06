package com.doom.geoservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public interface IBaseController {

    @GetMapping("initialize")
    boolean initialize();
}
