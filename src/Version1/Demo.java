package Version1;

/**
 * Created by u1773783 on 01/03/2018.
 */
public class Demo {

    private static GameController gameController;
    private MainMenu main;

    public static void main(String[] args) {
        gameController = new GameController();
        new MainMenu().display();

    }
}
