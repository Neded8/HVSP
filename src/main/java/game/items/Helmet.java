package game.items;

public class Helmet extends Item implements IArmor{
    private int protection;
    private final Eitem slot = Eitem.HELMET;
    private void setSlot() {
        super.slot = Eitem.HELMET;
    }
    private void setSprite() {
        super.sprite =
                "     _,.\n" +
                        "    ,` -.)\n" +
                        "   ( _/-\\\\-._\n" +
                        "  /,|`--._,-^|\n" +
                        "  \\_| |`-._/||\n" +
                        "    |  `-, / |\n" +
                        "    |     || |\n" +
                        "     `r-._||/ ";
    }

    public Helmet() {
        this.protection = 10;
        this.name = "Simple helmet";
        setSprite();
        setSlot();
    }

    public Helmet(String name,int protection) {
        this.name = name;
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
