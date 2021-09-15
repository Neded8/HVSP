package game.items;

public class HelmetEmpty extends Item implements IArmor{
    private int protection;
    private final Eitem slot = Eitem.HELMET;
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

    public HelmetEmpty() {
        this.protection = 0;
        this.name = "";
        setSprite();
    }

    public HelmetEmpty(String name, int protection) {
        this.name = name;
        this.protection = protection;
        setSprite();
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
