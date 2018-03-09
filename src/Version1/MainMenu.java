package Version1;

import javax.swing.*;

public class MainMenu {


    public JPanel getPanel1() {
        return panel1;
    }

    private JPanel panel1;
    private JButton startGameButton;
    private JButton quitButton;

    public static JFrame getGameFrame() {
        return gameFrame;
    }

    private static JFrame gameFrame;




    private Version1.GameController currentGame;

    public GameController getCurrentGame() {
        return currentGame;
    }

    public void display(){
        gameFrame = new JFrame("Sexy Quiz Game");
        gameFrame.setContentPane(new MainMenu().panel1);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
    }




}
