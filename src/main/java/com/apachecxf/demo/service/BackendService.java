package com.apachecxf.demo.service;

import cms.b2b.v01.*;
import com.apachecxf.demo.domain.PeekMessageResponse;
import com.apachecxf.demo.tools.StringToElementConverter;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Service
public class BackendService {

    PeekMessageResponseType  peekMessage(PeekMessageRequestType peekMessageRequest) throws Exception {
    PeekMessageResponse response = new PeekMessageResponse();
    PeekMessageResponseType responseType = new PeekMessageResponseType();
        ResponseMessageContainerType containerType = new ResponseMessageContainerType();
        ResponsePayloadType payloadType = new ResponsePayloadType();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document xmlDoc = documentBuilder.newDocument();

        Element root = xmlDoc.createElement("Hello");

        Node item = null;

        item = xmlDoc.createElement("Hello");
        item.appendChild(xmlDoc.createTextNode("World"));

        root.appendChild(item);
        xmlDoc.appendChild(root);

        payloadType.setAny(root);

        containerType.setPayload(payloadType);
        responseType.setMessageContainer(containerType);

    return responseType;
}
}
