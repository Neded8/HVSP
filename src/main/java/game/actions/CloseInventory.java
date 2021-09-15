package game.actions;

import game.items.Item;
import game.сreatures.Creature;

import java.util.List;

public class CloseInventory extends Action implements IAction, ISelfAction {
    @Override
    public IActionResult perform(Creature hero) {


        return new SimpleActionResult("You close your inventory");
    }

    @Override
    public String getActionDescription() {
        return "Close inventory, just continue the adventure";
    }

    @Override
    public String getActionName() {
        return "Close inventory";
    }
}
