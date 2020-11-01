package io.joaopinheiro.kafkatwitterproducer.app.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("kafka")
public class KafkaConfig {

    private String bootstrapServers;
}
