package game.actions;

public class CloseEquipmentMenu extends Action implements IAction{
    @Override
    public String getActionName() {
        return "Close";
    }

    @Override
    public String getActionDescription() {
        return "return to previous menu";
    }


}
