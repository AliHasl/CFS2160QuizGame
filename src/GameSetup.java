import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSetup {
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

    public GameSetup() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

                nextPanel = new MainMenu().getPanel1();
                MainMenu thisPanel = new MainMenu();
                thisPanel.setContentPane(nextPanel);
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
