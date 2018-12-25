package com.example.everything.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录过滤器
 *
 * @author win10
 */
@Component
public class AuthHeaderFilter extends ZuulFilter {

    /**
     * 过滤器类型，
     * PRE_TYPE：可以在请求被路由之前调用。
     * ROUTE_TYPE：在路由请求时候被调用。
     * ERROR_TYPE：处理请求时发生错误时被调用。
     * POST_TYPE：在routing和error过滤器之后被调用。
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器顺序，越小越先执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //System.out.println(request.getRequestURI()); ///apigateway/product/api/v1/product/list
        //System.out.println(request.getRequestURL()); //http://localhost:9000/apigateway/product/api/v1/product/list

        //判断哪些请求需要走过滤器
        if ("/everythingapigateway/product/v1/pro/id".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        } else if ("/everythingapigateway/order/v1/order/id".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        } else if ("/everythingapigateway/product/v1/pro/list".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        } else if ("/everythingapigateway/order/v1/order/list".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        }
        return false;
    }

    /**
     * 过滤器中具体地逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        //JWT
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //token对象
        String token = request.getHeader("token");

        if (StringUtils.isBlank((token))) {
            token = request.getParameter("token");
        }


        //登录校验逻辑  根据公司情况自定义 JWT
        if (StringUtils.isBlank(token)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
