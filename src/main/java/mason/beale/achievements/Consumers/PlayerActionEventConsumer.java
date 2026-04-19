package mason.beale.achievements.Consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PlayerActionEventConsumer {
    
    @KafkaListener(topics = "player-actions", groupId = "my-consumer-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
