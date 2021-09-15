package game.сreatures;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pig extends Creature {
    public void setSprite(){
        try {
            super.sprite = new String(Files.readAllBytes(Paths.get("D:\\HVSP\\src\\main\\resources\\Sprites\\PigDefault")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pig(String type, String name,  CreatureStats stats) {
        super(type, name,stats);
        setSprite();

    }

    public Pig() {
        super("Enemy","Crazy Pig",new CreatureStats(10, 4, 10));
        setSprite();
        addItemToInventory(itemFactory.getNewItem());
    }
}
