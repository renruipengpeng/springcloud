package com.renruipeng.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr--renruipeng
 * @date 2019-11-14
 **/
@RestController
@RequestMapping("/")
@Slf4j
public class TestApi {

    @GetMapping("/")
    public String get(){

        return "访问到我了>>>";

    }

}
