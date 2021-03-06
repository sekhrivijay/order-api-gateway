package com.services.micro.gateway.filter.order;

import com.google.gson.Gson;
import com.groupon.generated.request.GrouponRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.services.micro.gateway.order.GrouponOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

@Component
public class GrouponOrderApiFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(GrouponOrderApiFilter.class);

    private GrouponOrderService grouponOrderService;
    private Gson gson = new Gson();

    @Autowired
    public void setGrouponOrderService(GrouponOrderService grouponOrderService) {
        this.grouponOrderService = grouponOrderService;
    }

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
        RequestContext context = getCurrentContext();
        HttpServletRequest request = context.getRequest();
        LOGGER.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        try {

            BufferedReader reader = request.getReader();
            GrouponRequest reservationRequest = gson.fromJson(reader, GrouponRequest.class);
            HttpServletResponse servletResponse = context.getResponse();
            servletResponse.addHeader("Content-Type", "application/json; charset=utf-8");
            context.setResponseBody(gson.toJson(grouponOrderService.reserve(reservationRequest)));
            context.setSendZuulResponse(false);
        } catch (Exception e) {
            LOGGER.error("Could not send order", e);
        }

        return null;
    }


}
