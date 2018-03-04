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
    private JButton nintendoButton;
    private JButton segaButton;
    private JButton sonyButton;
    private JButton generalKnowledgeButton;
    private JLabel categorySelectTitle;
    private JPanel questionDisplay;
    private JButton option1;
    private JButton option2;
    private JButton option3;
    private JButton option4;
    private JLabel questionField;

    private static JFrame thisFrame;
    private GameController gameController;
    private Player currentPlayer;



    private String[] currentQuestion;

    /**
     *Method to start the GUI
     *
     */

    public void display(){

        thisFrame = new JFrame();

        thisFrame.setContentPane(new GeneralGUI().mainMenu);
        thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame.pack();
        thisFrame.setVisible(true);
    }

//    public String[] getQuestion(int category){
  //      gameController.presentQuestion(currentPlayer, category);
   // }

    public void formatQuestion(int category){
        currentQuestion = gameController.presentQuestion(currentPlayer,category);
        this.questionField.setText(currentQuestion[0]);

        this.option1.setText(currentQuestion[1]);
        this.option2.setText(currentQuestion[2]);
        this.option3.setText(currentQuestion[3]);
        this.option4.setText(currentQuestion[4]);

    }

    /**
     * Constructor for the GUI
     * Initialises the gameController, question database and list model.
     */

    public GeneralGUI() {
       // thisFrame = new JFrame("GeneralGUI");
        //playerList = new JList();
        gameController = new GameController();
        QuestionDatabase questionDatabase = new QuestionDatabase();
        playerList.setModel(gameController.getPlayers());

        /**
         * Methods for the MainMenu panel
         */

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                thisFrame.setContentPane(new GeneralGUI().gameSetup);

                thisFrame.pack();
                thisFrame.setVisible(true);

            }
        });

        /**
         * Methods for the playerEntry panel
         */

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(mainMenu);
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

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(gameController.getPlayers().size() == 0){
                    JOptionPane.showMessageDialog(thisFrame,"You must create at least one player to proceed.");
                }
                else {
                    currentPlayer = gameController.getPlayers().firstElement();
                    //JLabel playerTurn = new JLabel("Player " + currentPlayer.getName() + "'s turn.");
                    categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                    thisFrame.setContentPane(categorySelect);
                    thisFrame.pack();
                    thisFrame.setVisible(true);
                }
            }
        });
        /**
         * Methods for categorySelect panel
         */



        nintendoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(0);
                thisFrame.pack();
                thisFrame.setVisible(true);

            }
        });

        segaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(1);
                thisFrame.pack();
                thisFrame.setVisible(true);
            }
        });
        sonyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        generalKnowledgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        /**
         * Methods for questionDisplay panel
         */

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameController.setGuess(1);

            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameController.setGuess(2);
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameController.setGuess(3);
            }
        });
        option4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameController.setGuess(4);
            }
        });
    }
}
