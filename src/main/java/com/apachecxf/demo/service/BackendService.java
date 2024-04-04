package com.apachecxf.demo.service;

import cms.b2b.v01.*;
import com.apachecxf.demo.domain.PeekMessageResponse;
import com.apachecxf.demo.tools.StringToElementConverter;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;

@Service
public class BackendService {

    PeekMessageResponse  peekMessage(PeekMessageRequestType peekMessageRequest) throws Exception {
    PeekMessageResponse response = new PeekMessageResponse();
    PeekMessageResponseType responseType = new PeekMessageResponseType();
        MessageContainerType containerType = new MessageContainerType();
        PayloadType payloadType = new PayloadType();

    return response;
}
}
