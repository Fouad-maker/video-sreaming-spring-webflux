package com.fouedh.videosreamingspringwebflux.svc;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingSvc {

    private final static String FORMAT = "classpath:videos/%s.mp4";

    private ResourceLoader resourceLoader;

    public StreamingSvc(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Mono<Resource> loadVideos(String title) {
        return Mono.fromSupplier(()->resourceLoader.getResource(String.format(FORMAT,title)));
    }
    
}
