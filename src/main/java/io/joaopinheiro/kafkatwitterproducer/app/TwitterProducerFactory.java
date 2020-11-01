package io.joaopinheiro.kafkatwitterproducer.app;

import io.joaopinheiro.kafkatwitterproducer.app.kafka.KafkaProducerFactory;
import io.joaopinheiro.kafkatwitterproducer.app.twitter.TwitterClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterProducerFactory {

    private final TwitterClientFactory twitterClientFactory;
    private final KafkaProducerFactory kafkaProducerFactory;

    @Autowired
    public TwitterProducerFactory(TwitterClientFactory twitterClientFactory, KafkaProducerFactory kafkaProducerFactory) {
        this.twitterClientFactory = twitterClientFactory;
        this.kafkaProducerFactory = kafkaProducerFactory;
    }

    public TwitterProducer buildTwitterProducer() {
        var client = twitterClientFactory.buildTwitterClient();
        var kafkaProducer = kafkaProducerFactory.buildKafkaProducer();
        return new TwitterProducer(client, kafkaProducer);
    }

}
