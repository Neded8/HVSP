import java.util.Random;

public class BasicAttack extends Action implements IAction, ITargetAction{

    @Override
    public IActionResult perform(Creature initiator, Creature target) {
        Random random = new Random();
        float damage = initiator.getDamage() * (random.nextFloat()+0.3f)+10;
        target.setHealth(target.getHealth() - damage);
        return new SimpleActionResult ("Player " + initiator.getName() + " deal " + damage +" damage");

    }

    @Override
    public String getActionDescription() {
        return "Deals some damage";
    }

    @Override
    public String getActionName() {
        return "Basic Attack";
    }
}

