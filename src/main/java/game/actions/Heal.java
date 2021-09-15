package game.actions;

import game.сreatures.Creature;

public class Heal extends Action implements IAction, ISelfAction {
    @Override
    public IActionResult perform(Creature actor) {

        float restore = Math.min(actor.getMaxHP(), actor.getHealth() + 80);
        float restoredHealth = actor.getHealth() - restore;
        actor.setHealth(restore);
        return new SimpleActionResult("You restore " + restoredHealth * (-1) + " HP");
    }
    @Override
    public String getActionDescription() {
        return "Recover some HP";
    }

    @Override
    public String getActionName() {
        return "Trying to heal some HP";
    }

}
