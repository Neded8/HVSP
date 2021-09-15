package game;

import game.actions.*;
import game.сreatures.*;

import java.util.Random;

public class Controller {
    private Model model;
    private View view;
    private Creature victor;

    public Controller(Model model, View view) {
//        model.addNewLevel(0);
//        model.addNewLevel(0);
//        model.addNewLevel(200);
//        model.addNewLevel(500);
        this.model = model;
        this.view = view;

    }

    //    public void setPlayerName(game.сreatures.Creature player, String name) {
//        model.setActorName(player, name);
//    }
//
//    public void getPlayerName(game.сreatures.Creature player) {
//        model.getActorName(player);
//    }
//
//    public void setPlayerHP(game.сreatures.Creature player, int health) {
//        model.setActorHealth(player, health);
//    }
//
    private float getPlayerHP(Creature player) {
        return model.getActorHealth(player);
    }

    private void init() throws InstantiationException, IllegalAccessException {
        model.setHero(new Human());
        createEnemy2();
    }

    public void createPig() {
        model.setEnemy(new Pig("Enemy", "Wild Pig", new CreatureStats(10, 10, 10)));
        model.getEnemy().actionList.add(new BasicAttack());
    }

    public void createOrc() {
        model.setEnemy(new Orc("Enemy", "Old Orc", new CreatureStats(16, 2, 25)));
        model.getEnemy().actionList.add(new BasicAttack());
    }

    public void createElf() {
        model.setEnemy(new Bat("Enemy", "Crazy Bat", new CreatureStats(8, 40, 15)));
        model.getEnemy().actionList.add(new BasicAttack());
    }

    public void updateView() {
        //view.draw(model.getHero(), model.getEnemy());
        view.draw2(model.getHero(), model.getEnemy());
    }


    public IActionResult performAction(Creature self, Creature target, IAction action) {
        if (action instanceof ISelfAction) {
            ISelfAction sa = (ISelfAction) action;
            return sa.perform(self);
        }// else if (action instanceof ISelfInventory){
           // ((ISelfInventory) action).perform();
        //}
        else if (action instanceof ITargetAction) {
            return ((ITargetAction) action).perform(self, target);
        }
        throw new RuntimeException("Unknown action");
    }


    public void run() throws InstantiationException, IllegalAccessException {


        init();

        view.setMenu();
        view.clearScreen();
        model.getHero().actionList.add(new BasicAttack());
        model.getHero().actionList.add(new Heal());
        model.getHero().actionList.add(new OpenInventory());
        model.getHero().inventoryActionList.add(new TakeAllItems());
        model.getHero().inventoryActionList.add(new CloseInventory());
        model.getEnemy().actionList.add(new BasicAttack());

        while (true) {
            updateView();
            doOption();

            if (getPlayerHP(model.getHero()) <= 0 || getPlayerHP(model.getEnemy()) <= 0) {
                if (getPlayerHP(model.getHero()) > 0) {
                    view.printActionMessage(addExperience(model.getHero(), model.getEnemy()));
                    if (view.askContinue()) {
                        view.printActionMessage(performAction(model.getHero(), model.getEnemy(), model.getHero().inventoryActionList.get(view.showVictoryScreen(model.getEnemy())))) ;
                        createEnemy2();
                    } else {
                        break;
                    }
                } else {
                    view.showGameOverScreen();
                    break;
                }

            }
            if (getPlayerHP(model.getEnemy()) > 0) {
                view.printActionMessage(performAction(model.getEnemy(), model.getHero(), model.getEnemy().actionList.get(0)));
                view.clearScreen();
            }

        }
    }

    private void doOption() {
        view.printActionMessage(performAction(model.getHero(), model.getEnemy(), model.getHero().actionList.get(view.menu(model.getHero()))));
    }

    private void createEnemy() {

        Random random = new Random();
        float value = random.nextFloat();
        if (value < 0.33f) {
            createPig();
        } else if (value > 0.33f && value < 0.66f) {
            createElf();
        } else {
            createOrc();
        }

    }
    private void createEnemy2(){
        ActorFactory factory = new ActorFactory();
        model.setEnemy(factory.getNewCreature());
        model.getEnemy().actionList.add(new BasicAttack());
    }

    private IActionResult addExperience(Creature hero, Creature enemy) {
        String message = "";
        int currentLevel = model.getActorLevel(hero);
        model.setActorExperience(hero, model.getActorExperience(hero) + model.getActorLevel(enemy) * 103);
        message += "Experience added\n";
        if (model.getActorLevel(hero) > currentLevel) {
            message += "Level UP!\n";
            updateStats(hero);
        }
        return new SimpleActionResult(message);
    }

    private void updateStats(Creature hero) {
        CreatureStats stats = new CreatureStats(0, 0, 0);
        int strengthPerLevel = 3;
        int dexterityPerLevel = 1;
        int constitutionPerLevel = 2;
        stats.setConstitution(hero.getConstitution() + constitutionPerLevel * hero.getLevel());
        stats.setDexterity(hero.getDexterity() + dexterityPerLevel * hero.getLevel());
        stats.setStrength(hero.getStrength() + strengthPerLevel * hero.getLevel());

        hero.setStats(stats);
    }


}
