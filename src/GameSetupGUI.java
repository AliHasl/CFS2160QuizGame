import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSetupGUI {
    public JPanel getPanel1() {
        return panel1;
    }

    private JPanel panel1;
    private JButton backButton;
    private JButton startGameButton;
    private JTextField nameField;
    private JButton addButton;
    private JButton removeButton;
    private JList playerEntry;

    private JPanel nextPanel;
    private JFrame thisPanel;
    private GameController gameController;
    private DefaultListModel<Player> team;
    //private Player player;

    public GameSetupGUI() {
        gameController = new GameController();
        team =  gameController.getPlayers();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player = new Player(nameField.getText());


                team.addElement(player);
                playerEntry.setModel(team);


            }
        });


        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame thisframe = new MainMenu().getGameFrame();
                nextPanel = new MainMenu().getPanel1();
                thisframe.setContentPane(nextPanel);
                thisframe.pack();
                thisframe.setVisible(true);

            }
        });
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("Yo Mama");

            }
        });
    }
}
