package com.fouedh.videosreamingspringwebflux.controller;

import com.fouedh.videosreamingspringwebflux.svc.StreamingSvc;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StreamingController {
    private StreamingSvc streamingSvc;

    public StreamingController(StreamingSvc streamingSvc) {
        this.streamingSvc = streamingSvc;

    }

    @GetMapping(value = "/videos/{title}", produces = "videos/mp4")
    public Mono<Resource>  getVideos(@PathVariable final String title, final String range) {
        System.out.println("range in bytes(): " +range);
        return streamingSvc.loadVideos(title);

    }
}
