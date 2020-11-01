package io.joaopinheiro.kafkatwitterproducer.twitter;

import io.joaopinheiro.kafkatwitterproducer.twitter.client.TwitterClient;
import lombok.Value;

import java.util.concurrent.BlockingQueue;

@Value
public class TwitterProducer {

    TwitterClient client;
    //kafka producer

    public TwitterProducer(TwitterClient client) {
        this.client = client;
    }

    public void run() {
        client.connect();
        BlockingQueue<String> msgQueue = client.getMsgQueue();


        //produce into Kafka
    }
}
