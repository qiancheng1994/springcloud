package com.mengxuegu.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义登陆过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(getClass());


    /** 返回值
     * 为pre：在请求路由之前执行
     * 为route：在请求路由时执行
     * 为post：在请求路由之后执行，在route和error之后执行
     * 为error：在处理请求发生错误的时候执行
     * */
    @Override
    public String filterType() {
        return "pre";
    }

    // int值来定义过滤器的执行顺序，数据越小优先级越高
    @Override
    public int filterOrder() {
        return 1;
    }

    // 过滤器是否执行，true为执行，false不执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的业务逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest(); //获取请求参数token的值
        String token = request.getParameter("token");
        if (token == null) {
            logger.warn("此操作需要先登录系统...");
            context.setSendZuulResponse(false);// 拒绝访问
            context.setResponseStatusCode(200);// 设置响应状态码
            try {
                //响应结果
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return null;

    }
}
