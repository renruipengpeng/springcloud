package com.renruipeng.config;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.renruipeng.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Mr--renruipeng
 * @date 2019-11-26
 **/
@Slf4j
@Component
public class RequestFileter extends ZuulFilter {


    @Value("${nofilter.url}")
    private String url;

    /**
     *  <b>Filter类型</b>
     *  <li>PRE： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
     *  <li>ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
     *  <li>POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
     * <li>ERROR：在其他阶段发生错误时执行该过滤器。
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 优先级
     * <p>定义filter的顺序，数字越小表示顺序越高，越优先执行
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_ERROR_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        if(url.contains(request.getRequestURI())){

            return false;

        }

        return true;
    }

    @Override
    public Object run() throws ZuulException {

        //获取当前请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.getResponse().setContentType("application/json;charset=UTF-8");
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String url = httpServletRequest.getRequestURL().toString();
        String method =  httpServletRequest.getMethod();
        String token = httpServletRequest.getHeader("token");

        log.info("请求地址是:{},请求方法是:{},请求token是:{}",url,method,token);


        if("12345678".equalsIgnoreCase(token)){

            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(HttpStatus.OK.value());

        }else {

            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

            BaseResponse baseResponse =new BaseResponse(HttpStatus.UNAUTHORIZED.value(),HttpStatus.UNAUTHORIZED.name(),"token校验未通过");

            requestContext.setResponseBody(JSON.toJSONString(baseResponse));

        }

        return null;
    }
}
