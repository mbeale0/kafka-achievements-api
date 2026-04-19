package mason.beale.achievements.Consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import mason.beale.achievements.events.PlayerActionEvent;
import jakarta.validation.Valid;

@Service
public class PlayerActionEventConsumer {
    
    @KafkaListener(topics = "player-actions", groupId = "my-consumer-group")
    public void consume(@Valid PlayerActionEvent message) {
        System.out.println("Received message: " + message);
    }
}
