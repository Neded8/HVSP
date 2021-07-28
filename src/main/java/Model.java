import java.util.ArrayList;
import java.util.List;

public class Model {
    private Human Hero;
    private Pig Enemy;
    private List<Integer> levelSheetArrayList = new ArrayList<Integer>();

    public List<Integer> getLevelSheet() {
        return this.levelSheetArrayList;
    }

    public void addNewLevel(int experienceLevel) {
        this.levelSheetArrayList.add(experienceLevel);
    }

    public void addDamage(IStats actor) {
        actor.calcDamage();
    }

    public void changeLevelExperience(int level, int experienceLevel) {
        this.levelSheetArrayList.add(level - 1, experienceLevel);
    }

    public void setHero(Human hero) {
        Hero = hero;
    }

    public void setEnemy(Pig enemy) {
        this.Enemy = enemy;
    }

    public String getActorName(IStats actor) {
        return actor.getName();
    }

    public void setActorName(IStats actor, String name) {
        actor.setName(name);
    }

    public void setActorType(IStats actor, String type) {
        actor.setType(type);
    }

    public String getActorType(IStats actor) {
        return actor.getType();
    }

    public void setActorLevel(IStats actor, int level) {
        actor.setLevel(level);
    }

    public int getActorLevel(IStats actor) {
        return actor.getLevel();
    }

    public void setActorHealth(IStats actor, float health) {
        actor.setHealth(health);
    }

    public void setActorExperience(IStats actor, int experience) {
        actor.setExperience(experience);
    }

    ;

    public int getActorExperience(IStats actor) {
        return actor.getExperience();
    }

    public float getActorHealth(IStats actor) {
        return actor.getHealth();
    }

    public void setDamage(IStats actor, float damage) {
        actor.setDamage(damage);
    }

    ;

    public float getActorDamage(IStats actor) {
        return actor.getHealth();
    }

    public void setMaxHP(IStats actor, float maxHP) {
        actor.setMaxHP(maxHP);
    }

    ;

    public float getActorMaxHP(IStats actor) {
        return actor.getMaxHP();
    }

    public Human getHuman() {
        return this.Hero;
    }

    public Human getHero() {
        return this.Hero;
    }

    public Creature getEnemy() {
        return this.Enemy;
    }

    public Model() {
    }
}
