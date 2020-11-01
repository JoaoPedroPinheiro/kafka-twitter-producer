package io.joaopinheiro.kafkatwitterproducer.app.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaProducerFactory {

    private final KafkaConfig kafkaProperties;

    @Autowired
    public KafkaProducerFactory(KafkaConfig kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    public KafkaProducer<String,String> buildKafkaProducer() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());

        return new KafkaProducer<>(properties);
    }
}
