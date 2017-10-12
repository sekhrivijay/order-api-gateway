package com.services.micro.gateway.order;

import com.groupon.request.ReservationRequest;
import com.groupon.response.ReservationResponse;

public interface GrouponOrderService {
    ReservationResponse reserve(ReservationRequest reservationRequest) throws Exception;
}
