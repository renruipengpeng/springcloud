package com.renruipeng.webserver2.api;

import com.renruipeng.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr--renruipeng
 * @date 2019-11-13
 **/
@RestController
@RequestMapping("/test/web2")
@Slf4j
public class TestUserWebApi {

    @GetMapping("/getApiName")
    public BaseResponse<String> getApiName(@RequestParam(value = "name",defaultValue = "")String apiName){

        return  BaseResponse.success("服务2返回的值是:"+apiName);

    }

}
