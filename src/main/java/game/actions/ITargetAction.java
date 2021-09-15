package game.actions;

import game.сreatures.Creature;

public interface ITargetAction {
    IActionResult perform(Creature initiator, Creature target);
}
