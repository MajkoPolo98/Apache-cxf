package com.apachecxf.demo.domain;

import cms.b2b.v01.ResponsePayloadType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PeekMessageResponsePayload extends ResponsePayloadType {
    @XmlElement(name = "Payload22", required = true)
    private String payload;
}
