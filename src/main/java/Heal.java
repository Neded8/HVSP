public class Heal extends Action implements IAction, ISelfAction{
    @Override
    public IActionResult perform(Creature initiator) {

        float restore = Math.min(initiator.getMaxHP(), initiator.getHealth() + 80);
        float restoredHealth = initiator.getHealth() - restore;
        initiator.setHealth(restore);
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
