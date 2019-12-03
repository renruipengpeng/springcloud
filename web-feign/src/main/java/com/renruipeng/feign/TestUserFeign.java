package com.renruipeng.feign;

import com.renruipeng.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mr--renruipeng
 * @date 2019-11-13
 **/
@FeignClient(value = "web-server1")
public interface TestUserFeign {

    @GetMapping("/test/user/getUserName")
    public BaseResponse<String> getUserName(@RequestParam(value = "name",defaultValue = "")String name);

}
