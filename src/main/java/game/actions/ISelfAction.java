package game.actions;

import game.сreatures.Creature;

public interface ISelfAction {
    IActionResult perform(Creature initiator);
}
