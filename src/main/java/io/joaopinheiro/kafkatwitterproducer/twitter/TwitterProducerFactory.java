package io.joaopinheiro.kafkatwitterproducer.twitter;

import org.springframework.stereotype.Service;

@Service
public class TwitterProducerFactory {

    public TwitterProducer buildTwitterProducer() {
        return new TwitterProducer();
    }
}
