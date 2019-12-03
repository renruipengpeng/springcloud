package com.renruipeng.webserver2.api;

import com.renruipeng.BaseResponse;
import com.renruipeng.feign.TestUserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr--renruipeng
 * @date 2019-11-13
 **/
@RestController
@RequestMapping("/test/api")
@Slf4j
public class TestUserApi {

    @Autowired
    private TestUserFeign testUserFeign;

    @GetMapping("/getName")
    public BaseResponse<String> getName(@RequestParam(value = "name",defaultValue = "")String name){

        return  testUserFeign.getUserName(name);

    }

    @GetMapping("/getUserInfo")
    public BaseResponse<String> getUserInfo(@RequestParam(value = "age",defaultValue = "")Integer age){

        return BaseResponse.success("我是服务2的年龄是:"+age);

    }

    @GetMapping("/noFilter")
    public BaseResponse<String> noFilter(@RequestParam(value = "name",defaultValue = "")Integer name){

        return BaseResponse.success("我是不过滤的请求是:"+name);

    }


}
