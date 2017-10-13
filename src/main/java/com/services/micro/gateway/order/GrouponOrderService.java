package com.services.micro.gateway.order;

import com.groupon.generated.request.GrouponRequest;
import com.groupon.generated.response.GrouponResponse;

public interface GrouponOrderService {
    GrouponResponse reserve(GrouponRequest reservationRequest) throws Exception;
}
