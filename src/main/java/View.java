import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class View {
    List<Action> actions = new ArrayList<>();


    public void setMenu() {
        actions.add(new BasicAttack());
        actions.add(new Heal());
    }

    public List<Action> getActionList() {
        return actions;
    }

    public void draw(Human Player, Creature Enemy) {
        int Phealth = (int) Player.getHealth();
        int Ehealth = (int) Enemy.getHealth();
        System.out.println("\nName: " + Player.getName() + "\t\t Name: " + Enemy.getName());
        System.out.println("Type: " + Player.getType() + "\t Type: " + Enemy.getType());
        System.out.println("Level: " + Player.getLevel() + "\t\t Level: " + Enemy.getLevel());
        System.out.println("Experience: " + Player.getExperience() + "\t\t Experience: " + Enemy.getExperience());
        System.out.println("Health: " + Phealth + "\t\t Health: " + Ehealth);
        System.out.println("Damage: " + Player.getDamage() + "\t Damage: " + Enemy.getDamage());
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


    public int menu() {

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

        System.out.println("Your move is - " + actions.get(actionID).getActionName());
        return actionID;
    }

    public void victoryScreen() {

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
