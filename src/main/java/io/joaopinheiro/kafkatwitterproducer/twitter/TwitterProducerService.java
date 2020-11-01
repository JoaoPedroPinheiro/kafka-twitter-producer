package io.joaopinheiro.kafkatwitterproducer.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterProducerService {

    private final TwitterProducerFactory twitterProducerFactory;
    private TwitterProducer twitterProducer;

    @Autowired
    public TwitterProducerService(TwitterProducerFactory twitterProducerFactory) {
        this.twitterProducerFactory = twitterProducerFactory;
    }

    public void startProducer() {
        twitterProducer = twitterProducerFactory.buildTwitterProducer();
        twitterProducer.run();
    }
}
