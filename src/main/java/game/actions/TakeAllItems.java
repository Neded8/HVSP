package game.actions;

import game.items.Item;
import game.сreatures.Creature;

import java.util.List;

public class TakeAllItems extends Action implements IAction, ITargetAction {
    String addedItems = "";
    @Override
    public IActionResult perform(Creature hero,Creature enemy ) {
        for (int i = 0; i< enemy.getItems().size(); i++){
            boolean flag = false;
            for (int j = 0; j < hero.getItems().size(); j++){
                if (enemy.getItems().get(i).getItemName() == hero.getItems().get(j).getItemName()){
                    flag = true;
                }
                else {
                    continue;
                }
            }
            if (!flag){
                hero.addItemToInventory(enemy.getItems().get(i));
                addedItems += enemy.getItems().get(i).getItemName();
                addedItems += ", ";
            }
            flag = false;

        }
        return new SimpleActionResult("Items were added to your inventory: " + addedItems);
    }


    @Override
    public String getActionDescription() {
        return "Take all items to inventory";
    }

    @Override
    public String getActionName() {
        return "Take all";
    }
}
