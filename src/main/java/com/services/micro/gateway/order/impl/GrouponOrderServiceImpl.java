package com.services.micro.gateway.order.impl;

import com.groupon.request.ReservationRequest;
import com.groupon.response.Data;
import com.groupon.response.Product;
import com.groupon.response.ReservationResponse;
import com.services.micro.gateway.order.GrouponOrderService;
import com.services.micro.gateway.order.bl.OrderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.services.micro.gateway.order.util.OrderSoapClient;

import java.util.ArrayList;
import java.util.List;

@Service(value = "GrouponOrderService")
public class GrouponOrderServiceImpl implements GrouponOrderService {


    @Autowired
    private OrderBuilder orderBuilder;

    @Autowired
    private OrderSoapClient orderSoapClient;



    @Override
    public ReservationResponse reserve(ReservationRequest reservationRequest) throws Exception {
        ReservationResponse reservationResponse = new ReservationResponse();
        orderSoapClient.call(orderBuilder.build(reservationRequest));
        //Copy data from request onto response
        Data data = new Data();
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setId("123456");
        productList.add(product);

        data.setProducts(productList);
        reservationResponse.setData(data);
        return reservationResponse;
    }
}
