package game.actions;

import game.сreatures.Creature;

public class OpenInventory extends Action implements IAction, ISelfAction{
    @Override
    public IActionResult perform(Creature actor) {

        return new SimpleActionResult("Inventory Opened");
    }


    @Override
    public String getActionDescription() {
        return "Take a look in your inventory";
    }

    @Override
    public String getActionName() {
        return "Open inventory";
    }

}
