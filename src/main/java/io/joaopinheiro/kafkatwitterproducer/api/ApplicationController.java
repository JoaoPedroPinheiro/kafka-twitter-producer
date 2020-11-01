package io.joaopinheiro.kafkatwitterproducer.api;

import io.joaopinheiro.kafkatwitterproducer.app.TwitterProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class ApplicationController {

    private final TwitterProducerService twitterProducerService;

    public ApplicationController(TwitterProducerService twitterProducerService) {
        this.twitterProducerService = twitterProducerService;
    }

    @GetMapping("/status")
    public String health() {
        return "OK";
    }

    @GetMapping("/start")
    public ResponseEntity<HttpStatus> runTwitterProducer() {
        twitterProducerService.startProducer();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/stop")
    public ResponseEntity<HttpStatus> stopTwitterProducer() {
        twitterProducerService.stopProducer();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
