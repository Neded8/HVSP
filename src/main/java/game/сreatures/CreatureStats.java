package game.сreatures;

import java.util.Arrays;
import java.util.List;

public class CreatureStats {
    private int strength;
    private int dexterity;
    private int constitution;
    private int luck;
    List<Integer> levels = Arrays.asList(100, 300, 500, 800, 1200);

    public int getLevelExp(int level){
        return levels.get(level);
    }
    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getMaxHealth() {
        return constitution * 10;
    }

    public float getDamage() {
        return strength * 1.4f;
    }

    public int getLevel(int experience) {

        for (int i = 0; i < levels.size(); i++) {
            if (experience < levels.get(i))
                return i + 1;
        }
        return levels.size() + 1;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public CreatureStats(int strength, int dexterity, int constitution) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
    }
}
