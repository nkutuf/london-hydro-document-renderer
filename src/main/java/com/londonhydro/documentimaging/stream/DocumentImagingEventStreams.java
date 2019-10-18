package com.londonhydro.documentimaging.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DocumentImagingEventStreams {
    String INPUT = "bills-in";
    String OUTPUT = "bills-out";
    String LETTERINPUT = "letters-in";
    String LETTEROUTPUT = "letters-out";

    @Input(INPUT)
    SubscribableChannel inboundBills();
    @Input(LETTERINPUT)
    SubscribableChannel inboundLetters();

    @Output(OUTPUT)
    MessageChannel outboundBills();
    @Output(LETTEROUTPUT)
    SubscribableChannel outboundLetters();
}
