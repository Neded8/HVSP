import java.util.ArrayList;
import java.util.List;

public class Human extends Creature{
    private List<Item> items = new ArrayList<>();

    public Human(String type, String name, int level, int health, int maxHP, int damage) {
        super(type, name, level, health, maxHP, damage);
    }
    public Human() {

    }
    public void addItem(Item items) {
        this.items.add(items);
    }
}
