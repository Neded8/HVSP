import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class Action {
    public String getActionName() {
        throw new NotImplementedException();
    }

    public String getActionDescription() {
        throw new NotImplementedException();
    }
}