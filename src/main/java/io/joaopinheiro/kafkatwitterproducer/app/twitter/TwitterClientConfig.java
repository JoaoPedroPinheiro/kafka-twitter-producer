package io.joaopinheiro.kafkatwitterproducer.app.twitter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("twitter")
public class TwitterClientConfig {

    private String consumerSecret;
    private String consumerKey;
    private String token;
    private String tokenSecret;
}
