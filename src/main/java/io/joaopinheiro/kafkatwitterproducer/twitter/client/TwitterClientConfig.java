package io.joaopinheiro.kafkatwitterproducer.twitter.client;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Value
@Component
@ConfigurationProperties("twitter")
public class TwitterClientConfig {

    String consumerKey;
    String consumerSecret;
    String consumerToken;
    String secret;
}
