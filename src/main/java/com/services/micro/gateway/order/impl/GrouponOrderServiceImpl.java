package com.services.micro.gateway.order.impl;

import com.groupon.generated.request.GrouponRequest;
import com.groupon.generated.response.Data;
import com.groupon.generated.response.GrouponResponse;
import com.groupon.generated.response.Product;
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
    public GrouponResponse reserve(GrouponRequest reservationRequest) throws Exception {
        GrouponResponse reservationResponse = new GrouponResponse();
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
