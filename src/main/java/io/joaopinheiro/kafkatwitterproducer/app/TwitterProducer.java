package io.joaopinheiro.kafkatwitterproducer.app;

import io.joaopinheiro.kafkatwitterproducer.app.twitter.TwitterClient;
import lombok.Value;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Value
public class TwitterProducer implements Runnable{

    private static final String KAFKA_TOPIC = "twitter_stream";

    Logger logger = LoggerFactory.getLogger(TwitterProducer.class);

    TwitterClient client;
    Producer<String, String> kafkaProducer;

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
                    var record = new ProducerRecord<String, String>(KAFKA_TOPIC, msg);
                    kafkaProducer.send(record);
                    logger.info(msg);
                }
            }
        } catch (Exception e) {
            stop();
        }
    }

    public void stop() {
        client.stop();
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
