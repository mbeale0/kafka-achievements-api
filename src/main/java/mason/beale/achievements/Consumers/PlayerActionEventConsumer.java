package mason.beale.achievements.Consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import mason.beale.achievements.Models.PlayerAction;
import mason.beale.achievements.Models.PlayerActions;
import mason.beale.achievements.events.PlayerActionEvent;
import jakarta.validation.Valid;

// TODO:
// 1. Add error handling for invalid messages (schema validation, missing fields, etc.)
// 2. Implement logic to update player achievements based on the consumed events
// 3. Think of how to test
// 4. Consider the offset management
// 5. Consider idempotency
@Service
@Validated
public class PlayerActionEventConsumer {

    PlayerActions actions = PlayerActions.getActions();
    
    // TODO: more dynamic (10 achievments would not be fun)
    List<Integer> killThresholds = Arrays.asList(1, 5, 10);
    Map<Integer, Integer> playerKillCounts = new HashMap();


    // TODO: maybe not important for ths project, but a lot of this logic would probably be done in a service class?
    @KafkaListener(topics = "player-actions", groupId = "my-consumer-group")
    public void processPlayerAction(@Valid PlayerActionEvent message) {
        System.out.println("Received message: " + message.getAction() + " from player " + message.getPlayerId());

        // Determine if the action qualifies for an achievement - or is this handled via the producer/broker or something?
        boolean isValidAction = true; // Placeholder for actual validation logic
        if(!isValidAction) {
            System.out.println("Invalid action received: " + message.getAction() + " from player " + message.getPlayerId());
            return;
        }

        PlayerAction playerAction = new PlayerAction(message.getPlayerId(), message.getAction(), message.getTimestamp());
        actions.addToList(playerAction);
        
        
        checkIfAchievmentEarned(message);
    }

    private void checkIfAchievmentEarned(PlayerActionEvent message) {
        // todo: more dynamic action names
        if ("player_killed".equals(message.getAction())) {
            int actionCount = filterByPlayerAndAction(message.getPlayerId(), message.getAction()).size();
            
            for (Integer threshold : killThresholds) {
                if (actionCount == threshold) {
                    // TODO: Add to (and create) achievements "database" 
                    System.out.println(message.getPlayerId() + " unlocked achievement: " + threshold + " kills!");
                }
            }
        }
    }

    private ArrayList<PlayerAction> filterByPlayerAndAction(int playerId, String action) {
        return this.actions.getPlayerActions().stream()
            .filter(pa -> pa.getPlayerId() == playerId && pa.getAction().equals(action))
            .collect(Collectors.toCollection(ArrayList::new));
    }
}