package game.сreatures;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bat extends Creature {
    public void setSprite() {
        try {
            super.sprite = new String(Files.readAllBytes(Paths.get("D:\\HVSP\\src\\main\\resources\\Sprites\\BatDefault")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bat() {
        super("Enemy", "Black Bat", new CreatureStats(10, 15, 10));
        addItemToInventory(itemFactory.getNewItem());
        setSprite();
    }


    public Bat(String type, String name, CreatureStats stats) {
        super(type, name, stats);
        setSprite();
        addItemToInventory(itemFactory.getNewItem());
    }
}
