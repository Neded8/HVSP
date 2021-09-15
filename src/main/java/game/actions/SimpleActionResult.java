package game.actions;

import game.actions.IActionResult;

public class SimpleActionResult implements IActionResult {

    private String actionMessage;

    public SimpleActionResult(String actionMessage) {
        this.actionMessage = actionMessage;
    }

    @Override
    public String getActionResult() {
        return actionMessage;
    }
}
