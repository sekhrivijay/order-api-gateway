package com.services.micro.gateway.resource;

import com.groupon.generated.request.GrouponRequest;
import com.groupon.generated.response.GrouponResponse;
import com.services.micro.commons.logging.annotation.LogExecutionTime;
import com.services.micro.gateway.order.GrouponOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/groupon")
public class GrouponResource {

    private GrouponOrderService grouponOrderService;

    @Autowired
    public void setGrouponOrderService(GrouponOrderService grouponOrderService) {
        this.grouponOrderService = grouponOrderService;
    }

    @PostMapping(value = "/reserve",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @LogExecutionTime
    public GrouponResponse reserve(@RequestBody GrouponRequest reservationRequest) throws Exception {
        return grouponOrderService.reserve(reservationRequest);
    }

}



