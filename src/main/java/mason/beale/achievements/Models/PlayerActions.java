package mason.beale.achievements.Models;

import java.util.ArrayList;

public class PlayerActions {
    private static PlayerActions actions = null;

    private ArrayList<PlayerAction> playerActions = new ArrayList<>();

    // Constructors
    public PlayerActions() {}

    public static PlayerActions getActions() {
        if (actions == null) {
            actions = new PlayerActions();
        }
        return actions;
    }

    public void addToList(PlayerAction playerAction) {
        this.playerActions.add(playerAction);
    }

    public ArrayList<PlayerAction> getPlayerActions() {
        return this.playerActions;
    }

}