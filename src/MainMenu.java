import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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




    private GameController currentGame;

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


    public MainMenu() {
            startGameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    gameFrame.setContentPane(new GameSetupGUI().getPanel1());
                    gameFrame.pack();

                }
            });
            quitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {



                }
            });
        }

}
