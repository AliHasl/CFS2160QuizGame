package Version2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralGUI {
    private JPanel GeneralGUI;
    private JPanel mainMenu;
    private JPanel gameSetup;
    private JButton startButton;
    private JButton backButton;
    private JButton startGameButton;
    private JList playerList;
    private JButton addButton;
    private JButton removeButton;
    private JTextField nameField;
    private JPanel categorySelect;

    private static JFrame thisFrame;
    private GameController gameController;

    public void display(){
        //JFrame frame = thisFrame;


        thisFrame = new JFrame();

        thisFrame.setContentPane(new GeneralGUI().mainMenu);
        thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame.pack();
        thisFrame.setVisible(true);
    }

    public GeneralGUI() {
       // thisFrame = new JFrame("GeneralGUI");
        //playerList = new JList();
        gameController = new GameController();
        playerList.setModel(gameController.getPlayers());
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                thisFrame.setContentPane(new GeneralGUI().gameSetup);

                thisFrame.pack();
                thisFrame.setVisible(true);

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(new GeneralGUI().mainMenu);
                thisFrame.pack();
                thisFrame.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Player player = new Player(nameField.getText());
                gameController.addToTeam(player);




            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                int selectionNumber = playerList.getSelectedIndex();
                if(selectionNumber == -1){
                    JOptionPane.showMessageDialog(thisFrame,"Please select a player to remove.");

                }
                else {
                    gameController.removeFromTeam(selectionNumber);
                }
            }
        });
    }
}
