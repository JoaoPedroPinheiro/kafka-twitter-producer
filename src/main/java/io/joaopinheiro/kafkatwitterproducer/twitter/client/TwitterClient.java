package io.joaopinheiro.kafkatwitterproducer.twitter.client;

import com.twitter.hbc.core.Client;
import lombok.Value;

import java.util.concurrent.BlockingQueue;

@Value
public class TwitterClient {
    Client client;
    BlockingQueue<String> msgQueue;

    public TwitterClient(Client client, BlockingQueue<String> msgQueue) {
        this.client = client;
        this.msgQueue = msgQueue;
    }

    public void connect() {
        client.connect();
    }


}
