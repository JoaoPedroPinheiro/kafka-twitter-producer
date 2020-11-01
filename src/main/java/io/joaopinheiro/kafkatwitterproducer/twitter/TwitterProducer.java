package io.joaopinheiro.kafkatwitterproducer.twitter;

import io.joaopinheiro.kafkatwitterproducer.twitter.client.TwitterClient;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Value
public class TwitterProducer {

    Logger logger = LoggerFactory.getLogger(TwitterProducer.class);

    TwitterClient client;
    //kafka producer

    public TwitterProducer(TwitterClient client) {
        this.client = client;
    }

    public void run() {
        client.connect();
        BlockingQueue<String> msgQueue = client.getMsgQueue();

        try {
            while (!client.isDone()) {
                var msg = msgQueue.poll(5, TimeUnit.SECONDS);
                if (msg != null) {
                    logger.info(msg);
                }
            }
        } catch (Exception e){
            client.stop();
        }

        //read from msgQueue and produce into Kafka
    }
}
