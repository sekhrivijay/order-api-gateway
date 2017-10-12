package com.services.micro.gateway.order;

import com.groupon.generated.request.ReservationRequest;
import com.groupon.generated.response.ReservationResponse;

public interface GrouponOrderService {
    ReservationResponse reserve(ReservationRequest reservationRequest) throws Exception;
}
