package com.services.micro.gateway.filter.order.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpUrlConnection;

@Component
public class OrderSoapClient {

    @Value("${client.auth.header.user-name}")
    private String userName;

    @Value("${client.auth.header.password}")
    private String password;

    @Value("${client.default-uri}")
    private String defaultUri;

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public Object call(Object input) {
        return webServiceTemplate.marshalSendAndReceive(
                defaultUri,
                input,
                var1 -> addAuthHeader()
        );

    }

    private void addAuthHeader() {
        TransportContext context = TransportContextHolder.getTransportContext();
        HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();
        connection.getConnection().addRequestProperty("FTD_AUTH_USERNAME", userName);
        connection.getConnection().addRequestProperty("FTD_AUTH_PASSWORD", password);
    }


}
