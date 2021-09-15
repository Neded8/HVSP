package game.items;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ItemFactory {
    private List<Class<? extends Item>> itemClassList;

    public ItemFactory() {
        itemClassList = Arrays.asList(Shield.class, Sword.class, Helmet.class);
    }


    public Item getNewItem(Eitem item) throws InstantiationException, IllegalAccessException {
        switch (item){
            case SWORD:return itemClassList.get(1).newInstance();
            case HELMET:return itemClassList.get(2).newInstance();
            case SHIELD:return itemClassList.get(0).newInstance();
        }

        return null;
    }
    public Item getNewItem(){

        int randomNum = ThreadLocalRandom.current().nextInt(0, itemClassList.size());
        try {
            return itemClassList.get(randomNum).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("unable to create an item");
        }
    }
}
