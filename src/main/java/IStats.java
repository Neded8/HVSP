public interface IStats {
    void setLevel(int level);
    void setHealth(float health);
    void setDamage(float damage);
    void setMaxHP(float maxHP);
    void setType(String type);
    void setName(String name);
    void setExperience(int experience);
    String getName();
    String getType();
    void calcDamage();

    int getLevel();
    int getExperience();
    float getHealth();
    float getDamage();
    float getMaxHP();
}
