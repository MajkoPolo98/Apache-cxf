package com.apachecxf.demo.configuration;

import com.apachecxf.demo.service.MessageEndpoint;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.soap.SOAPBinding;
import org.apache.cxf.Bus;

import org.apache.cxf.binding.BindingConfiguration;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class ApplicationConfiguration {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(MessageEndpoint peekMessageEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, peekMessageEndpoint, SOAPBinding.SOAP12HTTP_BINDING);
        endpoint.publish("/service/message/");
        return endpoint;
    }
}
