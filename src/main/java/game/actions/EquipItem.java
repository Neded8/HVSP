package game.actions;

import game.сreatures.Creature;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EquipItem extends Action implements IAction,ISelfAction {
    @Override
    public IActionResult perform(Creature hero) {
        System.out.println("Which item you wanna equip?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int itemID;
        while (true) {
            try {
                itemID = Integer.parseInt(reader.readLine()) - 1;
                if (itemID < 0 || itemID > hero.getItems().size() - 1) {
                    System.out.println("Invalid input");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        hero.equipItem(hero.getItems().get(itemID));
        return new SimpleActionResult(hero.getItems().get(itemID).getItemName() + " was equipped");
    }

    @Override
    public String getActionName() {
        return "Equip the item";
    }

    @Override
    public String getActionDescription() {
        return "Put number of item which you wanna equip";
    }
}
