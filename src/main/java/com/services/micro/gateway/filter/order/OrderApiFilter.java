package com.services.micro.gateway.filter.order;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.services.micro.gateway.filter.order.bl.OrderBuilder;
import com.services.micro.gateway.filter.order.util.OrderSoapClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.UUID;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

@Component
public class OrderApiFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderApiFilter.class);


    @Autowired
    private OrderBuilder orderBuilder;

    @Autowired
    private OrderSoapClient orderSoapClient;



    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        LOGGER.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
//        HttpServletResponse response =  ctx.getResponse();
//        LOGGER.info(response.toString());


        RequestContext context = getCurrentContext();
        InputStream stream = context.getResponseDataStream();
        String body = null;
        try {
            body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Could not send order" , e);
        }
        context.setResponseBody("Modified via setResponseBody(): " + body);
        HttpServletResponse servletResponse = context.getResponse();
        servletResponse.addHeader("Content-Type", "application/text; charset=utf-8");
        servletResponse.addHeader("Content-Type2", "application/text; charset=utf-8");
        servletResponse.addHeader("X-Foo", UUID.randomUUID().toString());
        try {
            orderSoapClient.call(orderBuilder.build());
        }catch (Exception e) {
            LOGGER.error("Could not send order" , e);
        }

//        ctx.unset();
        context.setSendZuulResponse(false);
        return null;
    }


}
