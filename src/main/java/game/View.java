package game;

import game.actions.*;
import game.items.Item;
import game.сreatures.Creature;
import game.сreatures.Human;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class View {
    List<Action> actions = new ArrayList<>();
    List<Action> dropItemActions = new ArrayList<>();
    List<Action> inventoryItemActions = new ArrayList<>();


    public void setMenu() {
        actions.add(new BasicAttack());
        actions.add(new Heal());
        actions.add(new OpenInventory());
        dropItemActions.add(new TakeAllItems());
        dropItemActions.add(new CloseInventory());
        inventoryItemActions.add(new EquipItem());
        inventoryItemActions.add(new RemoveItem());
        inventoryItemActions.add(new CloseEquipmentMenu());


    }

//    public List<Action> getActionList() {
//        return actions;
//    }

    public void drawLine(float min, float max) {
        float blockPercent = min / max * 10;
        int amountBlocks = (int) blockPercent;
//        System.out.println(blockPercent);
        String ib = "⬛";
        String ob = "⬜";
        String eb = "▧";
        for (int i = 0; i < 10; i++) {
            if (i < amountBlocks) {
                if (amountBlocks == 0) {
                    System.out.print(eb);
                } else {
                    System.out.print(ib);
                }
            } else {
                System.out.print(ob);
            }

        }
    }

    public void draw2(Human hero, Creature enemy) {
        System.out.println(hero.getName() + "\t\t\t\t\t\t\t" + enemy.getName());
        drawLine(hero.getHealth(), hero.getMaxHP());
        System.out.print("\t\t\t\t\t");
        drawLine(enemy.getHealth(), enemy.getMaxHP());
        System.out.println();
        System.out.println("Level: " + hero.getLevel() + "\t\t\t\t\t\tLevel: " + enemy.getLevel());
        System.out.print("Exp: ");
        drawLine(hero.getExperience(), hero.getLevelExp(hero.getLevel()) + 1);
        System.out.println();
        printSprites(hero.getSprite(), enemy.getSprite());

    }


    public void showInventory(Creature hero) {
        System.out.println("Your inventory:");
        for (int i = 0; i < hero.getItems().size(); i++) {
            System.out.print(i + 1 + ": ");
            System.out.print(hero.getItems().get(i).getItemName());
            if (checkIfEquiped(hero, hero.getItems().get(i))) {
                System.out.println(" (equiped)");
            }
            System.out.println();
            System.out.println(hero.getItems().get(i).getItemSprite());
        }
        System.out.println("Available actions:");
        for (int i = 0; i < inventoryItemActions.size(); i++) {
            Action action = inventoryItemActions.get(i);
            System.out.println(String.valueOf(i + 1) + ": " + action.getActionName() + ": " + action.getActionDescription());
        }
        System.out.println("Choose action:");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        int actionID;
        while (true) {
            try {
                actionID = Integer.parseInt(reader.readLine()) - 1;
                if (actionID < 0 || actionID > actions.size() - 1) {
                    System.out.println("Invalid input");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        if (actionID >= 0 && actionID < 1) {
            Item choosenItem = chooseItem(hero);
            System.out.println("Your move is - " + inventoryItemActions.get(actionID).getActionName() + " " + choosenItem.getItemName());
            hero.equipItem(choosenItem);
        }

    }

    private boolean checkIfEquiped(Creature hero, Item item) {
        for (int k = 0; k < hero.getEquipedItems().size(); k++) {
            try {
                if (item.getItemName() == hero.getEquipedItems().get(k).item.getItemName()) {
                    return true;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return false;
    }

    private Item chooseItem(Creature actor) {
        System.out.println("Please, select item, which you wanna equip");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int itemID;
        while (true) {
            try {
                itemID = Integer.parseInt(reader.readLine()) - 1;
                if (itemID < 0 || itemID > actor.getItems().size()) {
                    System.out.println("Invalid input");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        return actor.getItems().get(itemID);
    }


    public int showVictoryScreen(Creature enemy) {
        //clearScreen();
        System.out.println("Dropped items: ");
        for (int i = 0; i < enemy.getItems().size(); i++) {
            System.out.print(i + 1 + ": ");
            System.out.println(enemy.getItems().get(i).getItemName());
            System.out.println(enemy.getItems().get(i).getItemSprite());

        }
        System.out.println("Available actions:");
        for (int i = 0; i < dropItemActions.size(); i++) {
            Action action = dropItemActions.get(i);
            System.out.println(String.valueOf(i + 1) + ": " + action.getActionName() + ": " + action.getActionDescription());
        }
        System.out.println("Choose action:");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        int actionID;
        while (true) {
            try {
                actionID = Integer.parseInt(reader.readLine()) - 1;
                if (actionID < 0 || actionID > actions.size() - 1) {
                    System.out.println("Invalid input");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }

        System.out.println("Your move is - " + actions.get(actionID).getActionName());
        return actionID;

    }


    private void printSprites(String hero, String enemy) {
//        String hero = heroSprite.replaceAll("\n","");
//        String enemy = enemySprite.replaceAll("\n","");
        char sd = '@';
        int inter = 1;
        for (char x : hero.toCharArray()) {
            if (x == sd) {
                while (inter < enemy.toCharArray().length) {
                    if (enemy.toCharArray()[inter] == sd) {
                        inter += 3;
                        break;
                    }
                    if (enemy.toCharArray()[inter] == sd) {
                        inter++;
                    } else {
                        System.out.print(enemy.toCharArray()[inter]);
                        inter++;
                    }
                }
            }
            if (x != sd) {
                System.out.print(x);
            } else {
                continue;
            }

        }
        System.out.println();
    }

    public void draw(Human player, Creature enemy) {
        int Phealth = (int) player.getHealth();
        int Ehealth = (int) enemy.getHealth();
        System.out.println("\nName: " + player.getName() + "\t\t Name: " + enemy.getName());
        System.out.println("Type: " + player.getType() + "\t Type: " + enemy.getType());
        System.out.println("Level: " + player.getLevel() + "\t\t Level: " + enemy.getLevel());
        System.out.println("Experience: " + player.getExperience() + "\t Experience: " + enemy.getExperience());
        System.out.println("Health: " + (int) player.getHealth() + "\t\t Health: " + (int) enemy.getHealth());
        System.out.println("Max Health: " + (int) player.getMaxHP() + "\t MaxHealth: " + (int) enemy.getMaxHP());
        System.out.println("Damage: " + player.getDamage() + "\t Damage: " + enemy.getDamage());

        System.out.println();
    }

    public void printActionMessage(IActionResult actionResult) {
        System.out.println(actionResult.getActionResult());
    }


    public void showGameOverScreen() {
        System.out.println("Game over");
    }

    public static void clearScreen() {

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }

    }


    public int menu(Human hero) {

        System.out.println("Available actions:");

        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            System.out.println(String.valueOf(i + 1) + ": " + action.getActionName() + ": " + action.getActionDescription());
        }

        System.out.println("Choose action:");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        int actionID;
        while (true) {
            try {
                actionID = Integer.parseInt(reader.readLine()) - 1;
                if (actionID < 0 || actionID > actions.size() - 1) {
                    System.out.println("Invalid input");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        if (actionID == 2) {
            showInventory(hero);
        }

        System.out.println("Your move is - " + actions.get(actionID).getActionName());
        return actionID;
    }


    public boolean askContinue() {
        System.out.println("Do you wanna fight more?\n1 - yes\n2 - no");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int actionID;
        try {
            actionID = Integer.parseInt(reader.readLine());
            if (actionID == 1) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
