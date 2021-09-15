package game.items;

public class Sword extends Item implements IWeapon {
    private int attack;
    private final Eitem slot = Eitem.SWORD;
    private void setSlot() {
        super.slot = Eitem.SWORD;
    }
    private void setSprite() {
        super.sprite = "       |\n" +
                "       /~\\\n" +
                "Oxxxxx|  (|=========================-\n" +
                " \\____/\\_/\n" +
                "       |";
    }

    public Sword() {
        this.name = "Simple sword";
        this.attack = 10;
        setSprite();
        setSlot();
    }

    public Sword(String name, int attack) {
        this.name = name;
        this.attack = attack;
        setSprite();
        setSlot();
    }

    @Override
    public int getWeaponDamage() {
        return this.attack;
    }


    @Override
    public String getItemName() {
        return this.name;
    }

    @Override
    public String getItemDescription() {
        return "Gain "+ String.valueOf(this.attack) +" attack damage";
    }
}
