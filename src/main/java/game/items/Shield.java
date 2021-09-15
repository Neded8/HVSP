package game.items;

public class Shield extends Item implements IArmor{
    private int protection;
    private final Eitem slot = Eitem.SHIELD;
    private void setSlot() {
        super.slot = Eitem.SHIELD;
    }
    private void setSprite() {
        super.sprite =
                        "   |`-._/\\_.-`|\n" +
                        "   |    ||    |\n" +
                        "   |___o()o___|\n" +
                        "   |__((<>))__|\n" +
                        "   \\   o\\/o   /\n" +
                        "    \\   ||   /\n" +
                        "     \\  ||  /\n" +
                        "      '.||.'\n" +
                        "        ``";
    }

    public Shield() {
        this.name = "Simple shield";
        this.protection = 10;
        setSprite();
        setSlot();
    }

    public Shield(String name ,int protection) {
        this.protection = protection;
        setSprite();
        setSlot();
    }

    @Override
    public int getWeaponArmor() {
        return this.protection;
    }

    @Override
    public String getItemName() {
        return this.name;
    }

    @Override
    public String getItemDescription() {
        return "Gain "+ String.valueOf(this.protection) +" armor";
    }
}
