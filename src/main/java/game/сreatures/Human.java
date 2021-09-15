package game.сreatures;

import game.items.Item;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Human extends Creature {

    public void setSprite() {
        try {
            super.sprite = new String(Files.readAllBytes(Paths.get("D:\\HVSP\\src\\main\\resources\\Sprites\\HumanNaked")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Item> equipment = new ArrayList<>();

    public Human(String type, String name, CreatureStats stats) {
        super(type, name, stats);
        setSprite();
    }

    public Human() {
        super("Player", "Fabrio", new CreatureStats(10, 10, 10));
        setSprite();

    }


}
