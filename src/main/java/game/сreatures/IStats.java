package game.сreatures;

public interface IStats {
    void setHealth(float health);
    void setType(String type);
    void setName(String name);
    void setExperience(int experience);
    String getName();
    String getType();


    int getExperience();

    int getLevel();

    float getHealth();
    float getDamage();
    float getMaxHP();
}
