package com.londonhydro.documentimaging.eventing;

import com.londonhydro.documentimaging.stream.DocumentImagingEventStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.w3c.dom.Document;

/**
 * DocumentImageProducer for Kafka Streaming API
 * author: Faisal Nkutu
 * date: September 04 2019
 */
@Service
@Slf4j
public class DocumentImageProducer {
    private final DocumentImagingEventStreams documentImagingEventStreams;
    @Autowired
    private MappingJackson2HttpMessageConverter jsonConverter;
    public DocumentImageProducer(DocumentImagingEventStreams documentImagingEventStreams) {
        this.documentImagingEventStreams = documentImagingEventStreams;
    }


    public void produceBillImage(final Document xmlBillData) {
        log.info("Sending BillImage {}", xmlBillData);

        MessageChannel messageChannel = documentImagingEventStreams.outboundBills();
        messageChannel.send(MessageBuilder
                .withPayload(xmlBillData)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
    public void produceLetterImage(final String letterOfReference) {
        log.info("Sending LetterImage {}", letterOfReference);

        MessageChannel messageChannel = documentImagingEventStreams.outboundLetters();
        messageChannel.send(MessageBuilder
                .withPayload(letterOfReference)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                .build());
    }
}
