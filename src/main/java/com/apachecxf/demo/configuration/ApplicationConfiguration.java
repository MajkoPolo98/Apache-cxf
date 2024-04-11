package com.apachecxf.demo.configuration;

import com.apachecxf.demo.service.MessageEndpoint;
import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.soap.SOAPBinding;
import org.apache.cxf.Bus;
import org.apache.cxf.annotations.GZIP;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.common.gzip.GZIPFeature;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    private Bus bus;

    @Bean
    public WSS4JOutInterceptor wss4JOutInterceptor() {
        WSS4JOutInterceptor wss4JOutInterceptor = new WSS4JOutInterceptor();
        // Configure WSS4J properties for encryption
        // For example:
        Map<String, Object> properties = new HashMap<>();
        properties.put(WSHandlerConstants.ACTION, "Encrypt Signature");
        //properties.put(WSHandlerConstants.USER, "sumuser");
        //properties.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        properties.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientPasswordCallback.class.getName());

        properties.put(WSHandlerConstants.ENCRYPTION_USER, "myservicekey");
        properties.put(WSHandlerConstants.ENC_PROP_FILE, "etc/serviceKeystore.properties");
        properties.put(WSHandlerConstants.SIGNATURE_USER, "myservicekey");
        properties.put(WSHandlerConstants.SIG_PROP_FILE, "etc/serviceKeystore.properties");

        // Add other necessary properties

        wss4JOutInterceptor.setProperties(properties);
        return wss4JOutInterceptor;
    }

    @Bean
    public Endpoint endpoint(MessageEndpoint peekMessageEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, peekMessageEndpoint, SOAPBinding.SOAP12HTTP_BINDING);
        endpoint.getOutInterceptors().add(wss4JOutInterceptor());

        endpoint.getOutInterceptors().add(new GZIPOutInterceptor());
        //endpoint.getOutInterceptors().add(new GZIPOutInterceptor(0));
        endpoint.getFeatures().add(new GZIPFeature());
        endpoint.publish("/service/message/");
        return endpoint;
    }
}
