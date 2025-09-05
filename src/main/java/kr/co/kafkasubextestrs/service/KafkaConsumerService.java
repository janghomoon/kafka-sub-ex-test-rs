package kr.co.kafkasubextestrs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "test-jhm-topic", groupId = "${spring.kafka.consumer.group-id}")//, groupId = "test-group"
    public void consume(String message) {
//        System.out.println("📩 받은 메시지: " + message);

        log.info("📩 받은 메시지: {}", message);

        // 메시지가 "error"일 경우 예외 발생
        if ("error".equalsIgnoreCase(message)) {
            log.error("❗❗❗ 예외 발생! 메시지: {}", message);
            throw new RuntimeException("처리 중 예외 발생");
        }
    }
}
