import java.util.ArrayList;
import java.util.List;

public class Creature extends Something implements IStats{
    private int level;
    private float health;
    private float damage;;
    private float maxHP;
    public List<IAction> actionList = new ArrayList<>();
    private int experience;

    public Creature(String type, String name, int level, int health, int maxHP, int damage) {

        this.setType(type);
        this.setName(name);
        this.setLevel(level);
        this.setHealth(health);
        this.setMaxHP(maxHP);
        this.setDamage(damage);
//        calcMaxHp();
//        calcDamage();
    }

    public Creature() {
    }
    public void calcDamage(){
        this.damage = this.damage + this.level + this.level * 1.3f + 5;
    }
    public void calcMaxHp(){
        this.maxHP = maxHP * 1.5f;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setHealth(float health){
        this.health = health;
    }
    public void setDamage(float damage){
        this.damage = damage;
    }
    public void setMaxHP(float maxHP){
        this.maxHP = maxHP;
    }
    public void setExperience(int experience){ this.experience = experience;}

    public int getLevel(){ return this.level;}
    public float getHealth(){ return this.health;}
    public float getDamage(){ return this.damage;}
    public float getMaxHP(){ return this.maxHP;}
    public int getExperience(){ return this.experience;}


}
