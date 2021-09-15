package game.сreatures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ActorFactory {
    private List<Class<? extends Creature>> creatureClassList;

    public ActorFactory() {
        creatureClassList = Arrays.asList(Orc.class, Bat.class, Pig.class);
        }


    public Creature getNewCreature() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, creatureClassList.size());
        //int randomNum = 1;
        try {
            return creatureClassList.get(randomNum).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("unable to create creature");
        }
    }
}

