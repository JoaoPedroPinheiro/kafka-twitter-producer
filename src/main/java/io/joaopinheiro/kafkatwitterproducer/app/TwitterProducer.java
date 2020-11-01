package io.joaopinheiro.kafkatwitterproducer.app;

import io.joaopinheiro.kafkatwitterproducer.app.twitter.TwitterClient;
import lombok.Value;
import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Value
public class TwitterProducer {

    Logger logger = LoggerFactory.getLogger(TwitterProducer.class);

    TwitterClient client;
    Producer<String, String> kafkaProducer;
    //kafka producer

    public TwitterProducer(TwitterClient client, Producer<String, String> kafkaProducer) {
        this.client = client;
        this.kafkaProducer = kafkaProducer;
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
