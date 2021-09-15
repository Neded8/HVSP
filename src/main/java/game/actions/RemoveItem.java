package game.actions;

import game.сreatures.Creature;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RemoveItem extends Action implements ISelfAction,IAction{
    @Override
    public IActionResult perform(Creature hero) {
        System.out.println("Equipped items:");
        for (int i=0; i< hero.getEquipedItems().size(); i++){
            if (hero.getEquipedItems().get(i) == null) {
                System.out.print(i+1 + ": ");
                System.out.print(hero.getEquipedItems().get(i).slot + " ");
                System.out.println(hero.getEquipedItems().get(i).item.getItemName());
                System.out.println(hero.getEquipedItems().get(i).item.getItemSprite());
            }else{
                System.out.print(i+1 + ": ");
                System.out.print(hero.getEquipedItems().get(i).slot + " [EMPTY]");
            }
        }
        System.out.println("Which item you wanna remove?");
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
        hero.removeItem(itemID);
        return new SimpleActionResult(hero.getEquipedItems().get(itemID) + " was removed");
    }
    @Override
    public String getActionName() {
        return "Remove the item";
    }

    @Override
    public String getActionDescription() {
        return "Put number of item which you wanna remove";
    }
}
