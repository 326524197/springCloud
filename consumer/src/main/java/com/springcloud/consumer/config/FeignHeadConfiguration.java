package com.springcloud.consumer.config;

import feign.RequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author heye
 * @date 2019/10/20
 */
@Configuration
public class FeignHeadConfiguration {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attrs != null) {
                HttpServletRequest request = attrs.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        String name = headerNames.nextElement();
                        String value = request.getHeader(name);
                        //处理 shiro 拦截导致session失效：遍历请求头里面的属性字段，将cookie添加到新的请求头中转发到下游服务
                        if ("cookie".equalsIgnoreCase(name)) {
                            logger.info("添加自定义请求头key:" + name + ",value:" + value);
                            requestTemplate.header(name, value);
                        } else {
                            logger.info("FeignHeadConfiguration:{}", "非自定义请求头key:" + name + ",value:" + value + "不需要添加!");
                        }
                    }
                } else {
                    logger.info("FeignHeadConfiguration", "获取请求头失败！");
                }
            }
        };
    }
}
