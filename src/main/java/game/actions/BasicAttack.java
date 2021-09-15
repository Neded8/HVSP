package game.actions;

import game.сreatures.Creature;

import java.util.Random;

public class BasicAttack extends Action implements IAction, ITargetAction {
    private int damagePerLevel = 3;

    @Override
    public IActionResult perform(Creature initiator, Creature target) {
        Random random = new Random();
        float damage = initiator.getDamage() * (random.nextFloat() + 0.3f) + 10;
        float hitChance = 0.9f - (float)target.getDexterity() / 100;
        float critChance = 0 + (float)target.getLuck() / 100;
        if (random.nextFloat() < hitChance) {
            if (random.nextFloat() > critChance) {
                target.setHealth(target.getHealth() - damage);
                return new SimpleActionResult("Player " + initiator.getName() + " deal " + damage + " damage");
            } else {
                target.setHealth(target.getHealth() - (damage * 2));
                return new SimpleActionResult("Player " + initiator.getName() + " deal " + damage + " CRITICAL damage");
            }
        } else {
            return new SimpleActionResult("Player " + initiator.getName() + "have tried to deal hit, but he failed");
        }


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

