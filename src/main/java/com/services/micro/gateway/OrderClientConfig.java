package com.services.micro.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.security.support.KeyStoreFactoryBean;
import org.springframework.ws.soap.security.support.TrustManagersFactoryBean;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

import javax.net.ssl.HostnameVerifier;

@Configuration
public class OrderClientConfig {
    private static final String LOCALHOST = "localhost";

    @Value("${client.default-uri}")
    private String defaultUri;

    @Value("${client.ssl.trust-store}")
    private Resource trustStore;

    @Value("${client.ssl.trust-store-password}")
    private String trustStorePassword;

    @Value("${client.context-package:com.ftd.pi.ic.ftdpartners.webservices}")
    private String contextPackage;

    @Bean
    Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath(contextPackage);
        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() throws Exception {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(defaultUri);
        webServiceTemplate.setMessageSender(httpsUrlConnectionMessageSender());

        return webServiceTemplate;
    }

    @Bean
    public HttpsUrlConnectionMessageSender httpsUrlConnectionMessageSender() throws Exception {
        HttpsUrlConnectionMessageSender httpsUrlConnectionMessageSender =
                new HttpsUrlConnectionMessageSender();
        httpsUrlConnectionMessageSender.setTrustManagers(trustManagersFactoryBean().getObject());
        httpsUrlConnectionMessageSender.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                return LOCALHOST.equals(hostname);
            }
        });

        return httpsUrlConnectionMessageSender;
    }

    @Bean
    public KeyStoreFactoryBean trustStore() {
        KeyStoreFactoryBean keyStoreFactoryBean = new KeyStoreFactoryBean();
        keyStoreFactoryBean.setLocation(trustStore);
        keyStoreFactoryBean.setPassword(trustStorePassword);
        return keyStoreFactoryBean;
    }

    @Bean
    public TrustManagersFactoryBean trustManagersFactoryBean() {
        TrustManagersFactoryBean trustManagersFactoryBean = new TrustManagersFactoryBean();
        trustManagersFactoryBean.setKeyStore(trustStore().getObject());
        return trustManagersFactoryBean;
    }
}
