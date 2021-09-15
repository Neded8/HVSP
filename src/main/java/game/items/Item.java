package game.items;

import game.сreatures.Something;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Item {
    String name;
    protected String sprite;
    protected Eitem slot;


    public Eitem getSlot() {
        return this.slot;
    }


    public String getItemName() {
        throw new NotImplementedException();
    }

    public String getItemDescription() {
        throw new NotImplementedException();
    }

    public String getItemSprite() {
        return sprite;
    }
}
