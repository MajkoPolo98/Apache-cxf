package com.apachecxf.demo.configuration;

import com.apachecxf.demo.service.MessageEndpoint;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;

import org.apache.cxf.binding.BindingConfiguration;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(MessageEndpoint peekMessageEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, peekMessageEndpoint);
        endpoint.setBindingConfig(new BindingConfiguration() {
            @Override
            public String getBindingId() {
                return "http://www.w3.org/2003/05/soap/bindings/HTTP/";//SOAPVersion.SOAP_12.httpBindingId
            }
        });
        endpoint.publish("/service/message/");
        return endpoint;
    }
}
