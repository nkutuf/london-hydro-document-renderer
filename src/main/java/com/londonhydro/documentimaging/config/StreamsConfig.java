package com.londonhydro.documentimaging.config;

import com.londonhydro.documentimaging.stream.DocumentImagingEventStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(DocumentImagingEventStreams.class)
public class StreamsConfig {
}
