package com.apachecxf.demo.service;

import cms.b2b.service.v01.MarketMessagingB2BInboundServiceV01PortType;
import cms.b2b.v01.DequeueMessageRequestType;
import cms.b2b.v01.PeekMessageRequestType;
import cms.b2b.v01.PeekMessageResponseType;
import cms.b2b.v01.SendMessageRequestType;

import org.springframework.stereotype.Service;

@Service
public class MessageEndpoint implements MarketMessagingB2BInboundServiceV01PortType {

    BackendService service;

    public MessageEndpoint(BackendService service) {
        this.service = service;
    }

    @Override
    public void sendMessage(SendMessageRequestType parameters) {
    }

    @Override
    public void dequeueMessage(DequeueMessageRequestType parameters) {

    }

    @Override
    public PeekMessageResponseType peekMessage(PeekMessageRequestType parameters) {
        return service.peekMessage(parameters);
    }
}
