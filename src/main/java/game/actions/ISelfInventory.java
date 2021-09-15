package game.actions;

import game.items.Item;
import game.сreatures.Creature;


import java.util.List;

public interface ISelfInventory {
    IActionResult perform(Creature actor,List<Item> list);
}
