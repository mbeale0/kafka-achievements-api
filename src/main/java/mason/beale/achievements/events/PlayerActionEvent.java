package mason.beale.achievements.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class PlayerActionEvent {
    
    @NotNull(message = "playerId is required")
    @JsonProperty("playerId")
    private int playerId;
    
    @NotNull(message = "action is required")
    @JsonProperty("action")
    private String action;
    

    
    @NotNull(message = "timestamp is required")
    @JsonProperty("timestamp")
    private long timestamp;
    
    // Constructors
    public PlayerActionEvent() {
    }
    
    public PlayerActionEvent(int playerId, String action, int points, long timestamp) {
        this.playerId = playerId;
        this.action = action;
        this.timestamp = timestamp;
    }
    
    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }
    
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    
    public String getAction() {
        return action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "PlayerActionEvent{" +
                "playerId=" + playerId +
                ", action='" + action + '\'' +
                ", points=" + points +
                ", timestamp=" + timestamp +
                '}';
    }
}
