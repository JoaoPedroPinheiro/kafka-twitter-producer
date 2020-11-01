package io.joaopinheiro.kafkatwitterproducer.twitter;

import io.joaopinheiro.kafkatwitterproducer.twitter.client.TwitterClient;
import io.joaopinheiro.kafkatwitterproducer.twitter.client.TwitterClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterProducerFactory {

    private final TwitterClientFactory twitterClientFactory;

    @Autowired
    public TwitterProducerFactory(TwitterClientFactory twitterClientFactory) {
        this.twitterClientFactory = twitterClientFactory;
    }

    public TwitterProducer buildTwitterProducer() {
        TwitterClient client = twitterClientFactory.buildTwitterClient();

        return new TwitterProducer(client);
    }


}
