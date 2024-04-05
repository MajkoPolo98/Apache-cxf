package com.apachecxf.demo.service;

import cms.b2b.v01.*;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.soap.SOAPBinding;
import org.springframework.stereotype.Service;

@Service
public class BackendService {

    public PeekMessageResponseType  peekMessage(PeekMessageRequestType peekMessageRequest) {
    PeekMessageResponseType responseType = new PeekMessageResponseType();
    PeekMessageResponseType.PeekMessageResponse peekMessageResponse = new PeekMessageResponseType.PeekMessageResponse();
        PeekMessageResponseType.PeekMessageResponse.MessageContainer messageContainer = new PeekMessageResponseType.PeekMessageResponse.MessageContainer();
        PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload peekMessageResponsePayload = new PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload();
        PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload.OperationResult operationResult = new PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload.OperationResult();
        PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload.OperationResult.ProcessEnergyContext processEnergyContext = new PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload.OperationResult.ProcessEnergyContext();
        processEnergyContext.setBusinessProcess("HelloWorld");
        processEnergyContext.setBusinessProcessMessageType("HelloWorld");
        processEnergyContext.setBusinessProcessTypeResponsibleOrganization("HelloWorld");
        PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload.OperationResult.Payload payload = new PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload.OperationResult.Payload();
        operationResult.setProcessEnergyContext(processEnergyContext);
        PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload.OperationResult.Payload.Result result = new PeekMessageResponseType.PeekMessageResponse.MessageContainer.PeekMessageResponsePayload.OperationResult.Payload.Result();
        result.setErrorCode("Error Code");

        peekMessageResponsePayload.setOperationResult(operationResult);
        messageContainer.setPeekMessageResponsePayload(peekMessageResponsePayload);
        peekMessageResponse.setMessageContainer(messageContainer);
        responseType.setPeekMessageResponse(peekMessageResponse);

    return responseType;
}
}
