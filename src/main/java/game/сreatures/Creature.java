package game.сreatures;

import game.actions.IAction;
import game.items.*;

import java.util.ArrayList;
import java.util.List;

public class Creature extends Something implements IStats {
    private float health;
    private int experience;
    private CreatureStats stats;
    protected String sprite;
    protected ItemFactory itemFactory = new ItemFactory();
    public List<IAction> actionList = new ArrayList<>();
    public List<IAction> inventoryActionList = new ArrayList<>();
    protected List<Item> inventory = new ArrayList<>();
    protected List<EquipedItems> equipedItems = new ArrayList<>();


    public List<EquipedItems> getEquipedItems() {
        return equipedItems;
    }

    public String getSprite() {
        return sprite;
    }


    public Creature(String type, String name, CreatureStats stats) {

        this.setType(type);
        this.setName(name);
        this.setHealth(stats.getMaxHealth());
        this.stats = stats;
        this.stats.setLuck(5);
        this.equipedItems.add(new EquipedItems());
        this.equipedItems.add(new EquipedItems());
        this.equipedItems.add(new EquipedItems());
        this.equipedItems.get(0).slot = Eitem.SWORD;
        this.equipedItems.get(1).slot = Eitem.HELMET;
        this.equipedItems.get(2).slot = Eitem.SHIELD;


    }

    public Creature() {
    }

    public Creature(CreatureStats stats) {
        this.stats = stats;
        this.health = stats.getMaxHealth();

    }

    //////////getters+setters///////
    public void setHealth(float health) {
        this.health = health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return stats.getLevel(this.experience);
    }

    public float getHealth() {
        return this.health;
    }

    public float getDamage() {
        return this.stats.getDamage();
    }

    public float getMaxHP() {
        return this.stats.getMaxHealth();
    }

    public int getExperience() {
        return this.experience;
    }

    public int getLuck() {
        return stats.getLuck();
    }

    public int getDexterity() {
        return stats.getDexterity();
    }

    public int getConstitution() {
        return stats.getConstitution();
    }

    public int getStrength() {
        return stats.getStrength();
    }

    public int getLevelExp(int level) {
        return this.stats.getLevelExp(level);
    }

    public CreatureStats getStats() {
        return stats;
    }

    public void setStats(CreatureStats stats) {
        this.stats = stats;
    }

    public List<Item> getItems() {
        return inventory;
    }

    public void setItems(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addItemToInventory(Item item) {
        this.inventory.add(item);
    }


    public void equipItem(Item item) {
        for (int i = 0; i < this.equipedItems.size(); i++){
            if (item.getSlot() == this.equipedItems.get(i).slot){
                this.equipedItems.get(i).item = item;
                break;
            }
        }
    }

    public void removeItem(int equipedItem) {
        equipedItems.get(equipedItem).item = null;
    }
}