package mason.beale.achievements.Models;

public class PlayerAction {

    private int playerId;
    private String action;
    private long timestamp;

    // Constructors
    public PlayerAction() {}

    public PlayerAction(int playerId, String action, long timestamp) {
        this.playerId = playerId;
        this.action = action;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public String getAction() {
        return action;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
