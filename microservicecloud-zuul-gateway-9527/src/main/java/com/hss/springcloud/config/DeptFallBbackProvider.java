package com.hss.springcloud.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hss.springcloud.utils.MyClientHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 如果需要在Zuul网关服务中增加容错处理fallback，需要实现接口ZuulFallbackProvider
 * spring-cloud框架，在Edgware版本(包括)之后，声明接口ZuulFallbackProvider过期失效，
 * 提供了新的ZuulFallbackProvider的子接口 - FallbackProvider
 * 在老版本中提供的ZuulFallbackProvider中，定义了两个方法。
 *  - String getRoute()
 *    当前的fallback容错处理逻辑处理的是哪一个服务。可以使用通配符‘*’代表为全部的服务提供容错处理。
 *    如果只为某一个服务提供容错，返回对应服务的spring.application.name值。
 *  - ClientHttpResponse fallbackResponse()
 *    当服务发生错误的时候，如何容错。
 * 新版本中提供的FallbackProvider提供了新的方法。
 *  - ClientHttpResponse fallbackResponse(Throwable cause)
 *    如果使用新版本中定义的接口来做容错处理，容错处理逻辑，只运行子接口中定义的新方法。也就是有参方法。
 *    是为远程服务发生异常的时候，通过异常的类型来运行不同的容错逻辑。
 */
@Component
public class DeptFallBbackProvider implements ZuulFallbackProvider {

    private static final Logger logger = LoggerFactory.getLogger(DeptFallBbackProvider.class);

    /**
     * return - 返回fallback处理哪一个服务。返回的是服务的名称
     * 推荐 - 为指定的服务定义特性化的fallback逻辑。
     * 推荐 - 提供一个处理所有服务的fallback逻辑。
     * 好处 - 服务某个服务发生超时，那么指定的fallback逻辑执行。如果有新服务上线，未提供fallback逻辑，有一个通用的。
     */
    @Override
    public String getRoute() {
        return "microservicecloud-dept";
    }

    /**
     * fallback逻辑。在早期版本中使用。
     * Edgware版本之后，ZuulFallbackProvider接口过期，提供了新的子接口FallbackProvider
     * 子接口中提供了方法ClientHttpResponse fallbackResponse(Throwable cause)。
     * 优先调用子接口新定义的fallback处理逻辑。
     */
    @Override
    public ClientHttpResponse fallbackResponse() {
        logger.info("ClientHttpResponse fallbackResponse()");

        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();
        data.put("message", "服务正忙，请稍后重试");
        result.add(data);

        ObjectMapper mapper = new ObjectMapper();

        String msg = "";
        try {
            msg = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            msg = "";
        }

        return MyClientHttpResponse.executeHttpResponse(HttpStatus.OK, msg,
                "application", "json", "utf-8");
    }
}
