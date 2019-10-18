package com.londonhydro.documentimaging.eventing;


import com.londonhydro.documentimaging.stream.DocumentImagingEventStreams;
import com.londonhydro.documentimaging.transformation.DocumentImageModel;
import com.londonhydro.documentimaging.transformation.TemplateFactory;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import java.util.Iterator;

/**
 * DocumentImageConsumer for Kafka Streaming API
 * author: Faisal Nkutu
 * date: September 04 2019
 */

@Component
@Slf4j
public class DocumentImageConsumer {

    @StreamListener(DocumentImagingEventStreams.INPUT)
    public void receiveBills(@Payload Document billImage) {
        log.info("Received billImage: {}", billImage.getDocumentElement());
        //Optional 2 Save after consuming from Kafka
        TemplateFactory templateFactory = new TemplateFactory();
        templateFactory.createBillTemplate("thisWasConsumedFromKafka3.pdf",billImage);

    }
    @StreamListener(DocumentImagingEventStreams.LETTERINPUT)
    public void receiveLetterTemplate(@Payload String letterOfReferenceTemplate) {
        JSONObject json = new JSONObject(letterOfReferenceTemplate.toString());
        DocumentImageModel dim = new DocumentImageModel();
        for (Iterator fieldKey = json.keys(); fieldKey.hasNext();) {
            String field = (String) fieldKey.next();
            JSONObject name = (JSONObject) json.get(field);
            Iterator<String> ltrOfReference = name.keys();
            //replace Default Values for Document Image Model
            while (ltrOfReference.hasNext()) {
                String fieldKeys = ltrOfReference.next();
                String fieldValue = name.getString(fieldKeys);
                dim.setFirstParagraph(fieldValue);
                dim.setSecondParagraph(fieldValue);
                dim.setThirdParagraph(fieldValue);
                dim.setFourthParagraph(fieldValue);
                dim.setServiceType(fieldValue);
                dim.setSubject(fieldValue);
            }

        }
        System.out.println("Received letterTemplateImage: ====>" + letterOfReferenceTemplate);
    }
}
