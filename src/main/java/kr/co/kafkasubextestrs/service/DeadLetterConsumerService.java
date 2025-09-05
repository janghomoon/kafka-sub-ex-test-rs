package kr.co.kafkasubextestrs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeadLetterConsumerService {
    @KafkaListener(topics = "test-jhm-topic.DLT", groupId = "dlt-group")
    public void consumeDLT(String message) {

        log.info("DLT consumed message: {}", message);
    }
}
