public class Controller {
    private Model model;
    private View view;
    private Creature victor;

    public Controller(Model model, View view) {
        model.addNewLevel(0);
        model.addNewLevel(0);
        model.addNewLevel(200);
        model.addNewLevel(500);
        this.model = model;
        this.view = view;

    }

    //    public void setPlayerName(Creature player, String name) {
//        model.setActorName(player, name);
//    }
//
//    public void getPlayerName(Creature player) {
//        model.getActorName(player);
//    }
//
//    public void setPlayerHP(Creature player, int health) {
//        model.setActorHealth(player, health);
//    }
//
    public float getPlayerHP(Creature player) {
        return model.getActorHealth(player);
    }

    public void init() {
        model.setHero(new Human("Player", "Bob ", 1, 100, 100, 10));
        model.setEnemy(new Pig("Enemy", "Wild Pig", 1, 100, 100, 10));
    }

    public void createPig() {
        model.setEnemy(new Pig("Enemy", "Wild Pig", 1, 100, 100, 10));
        model.getEnemy().actionList.add(new BasicAttack());
    }

    public void updateView() {
        view.draw(model.getHero(), model.getEnemy());
    }


    public IActionResult performAction(Creature self, Creature target, IAction action) {
        if (action instanceof ISelfAction) {
            ISelfAction sa = (ISelfAction) action;
            return sa.perform(self);
        } else if (action instanceof ITargetAction) {
            return ((ITargetAction) action).perform(self, target);
        }
        throw new RuntimeException("Unknown action");
    }


    public void run() {


        init();

        view.setMenu();
        view.clearScreen();

        model.getHero().actionList.add(new BasicAttack());
        model.getHero().actionList.add(new Heal());
        model.getEnemy().actionList.add(new BasicAttack());

        while (true) {
            updateView();
            view.printActionMessage(performAction(model.getHero(), model.getEnemy(), model.getHero().actionList.get(view.menu())));
            if (getPlayerHP(model.getHero()) <= 0 || getPlayerHP(model.getEnemy()) <= 0) {
                if (getPlayerHP(model.getHero()) > 0) {
                    view.printActionMessage(addExperience(model.getHero(), model.getEnemy()));
                    if (view.askContinue()) {
                        createPig();
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

    private IActionResult addExperience(Creature hero, Creature enemy) {
        String message = null;
        if (model.getActorExperience(hero) > model.getLevelSheet().get(model.getActorLevel(hero)+1)) {
            model.setActorLevel(hero, model.getActorLevel(hero) + 1);
            model.addDamage(hero);
            message = "Level up!\n";
        }
        model.setActorExperience(hero, model.getActorExperience(hero) + model.getActorLevel(enemy) * 103);
        message = message + "Experience added";
        return new SimpleActionResult(message);
    }


}
