package io.joaopinheiro.kafkatwitterproducer.twitter.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("twitter")
public class TwitterClientConfig {

    String consumerKey;
    String consumerSecret;
    String token;
    String tokenSecret;
}
