package game.сreatures;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Orc extends Creature {
    private void setSprite() {
        try {
            super.sprite = new String(Files.readAllBytes(Paths.get("D:\\HVSP\\src\\main\\resources\\Sprites\\OrcDefault")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Orc() {
        super("Enemy","Old Orc",new CreatureStats(15, 4, 10));
        setSprite();
        addItemToInventory(itemFactory.getNewItem());
    }

    public Orc(String type, String name,   CreatureStats stats) {
        super(type, name,stats);
        setSprite();
    }
}