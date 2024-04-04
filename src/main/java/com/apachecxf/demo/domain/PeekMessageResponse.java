package com.apachecxf.demo.domain;

import cms.b2b.v01.PeekMessageResponseType;
import cms.b2b.v01.ResponseMessageContainerType;
import cms.b2b.v01.ResponsePayloadType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PeekMessageResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class PeekMessageResponse extends PeekMessageResponseType {

    PeekMessageResponseType peekMessageResponseType;
    @XmlElement(name = "MessageContainer")
    private ResponseMessageContainerType messageContainer;

    public PeekMessageResponse() {
        ResponseMessageContainerType responseMessageContainerType = new ResponseMessageContainerType();
        ResponsePayloadType responsePayloadType = new ResponsePayloadType();


        responseMessageContainerType.setPayload(responsePayloadType);
        this.messageContainer = responseMessageContainerType;
    }

    public ResponseMessageContainerType getMessageContainer() {
        return messageContainer;
    }

    public void setMessageContainer(ResponseMessageContainerType messageContainer) {
        this.messageContainer = messageContainer;
    }


}
