import game.Controller;
import game.Model;
import game.View;

public class App {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.run();

    }

    

}
