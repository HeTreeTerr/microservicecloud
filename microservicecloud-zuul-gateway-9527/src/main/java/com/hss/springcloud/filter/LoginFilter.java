package com.hss.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用zuul实现身份鉴权
 */
@Component
public class LoginFilter extends ZuulFilter{
    private static final Logger logger = LoggerFactory.getLogger(LoggerFilter.class);

    /**
     * 返回boolean类型。代表当前filter是否生效。
     * 默认值为false。
     * 返回true代表开启filter。
     */
    @Override
    public boolean shouldFilter() {
        //设定拦截的黑白名单

        return true;
    }

    /**
     * run方法就是过滤器的具体逻辑。
     * return 可以返回任意的对象，当前实现忽略。（spring-cloud-zuul官方解释）
     * 直接返回null即可。
     */
    @Override
    public Object run() {
        // 通过zuul，获取请求上下文
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();

        logger.info("LoginFilter.....");

        // 可以记录日志、鉴权，给维护人员记录提供定位协助、统计性能
        Boolean flag = false;
        if (flag) {
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            rc.setResponseBody("Authentication failed!");
        }
        return null;
    }

    /**
     * 过滤器的类型。可选值有：
     * pre - 前置过滤
     * route - 路由后过滤
     * error - 异常过滤
     * post - 远程服务调用后过滤
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 同种类的过滤器的执行顺序。
     * 按照返回值的自然升序执行。
     */
    @Override
    public int filterOrder() {
        return 1;
    }
}
