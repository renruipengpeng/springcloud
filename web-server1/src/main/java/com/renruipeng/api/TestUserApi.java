package com.renruipeng.api;

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
@Slf4j
@RequestMapping("/test/user")
public class TestUserApi {

    @GetMapping("/getUserName")
    public BaseResponse<String> getResult(@RequestParam(value = "name",defaultValue = "")String name){

        log.info("输入的名称是:{}",name);

        return BaseResponse.success("您输入的名称是:"+name);

    }

    @GetMapping("/validate")
    public BaseResponse<String> validate(@RequestParam(value = "accessToken",defaultValue = "")String accessToken){

        log.info("传入的参数是:{}",accessToken);

        return BaseResponse.success(accessToken);

    }

    @GetMapping("/noValidate")
    public BaseResponse<String> noValidate(@RequestParam(value = "noParam",defaultValue = "")String noParam){

        log.info("传入的参数是:{}",noParam);

        return BaseResponse.success(noParam);

    }

}
