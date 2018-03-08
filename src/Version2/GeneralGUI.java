package Version2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
    private JButton continueButton;

    private JPanel titleImagePanel;


    private static JFrame thisFrame;
    private GameController gameController;
    private Player currentPlayer;
    private int playerIndex;



    private String[] currentQuestion;

    /**
     *Method to start the GUI
     *
     */

    public void display(){

        thisFrame = new JFrame();
        try {
            BufferedImage titleImage = ImageIO.read(new File("src/Version2/Bamboozle.jpg"));
            JLabel titleImageLabel = new JLabel(new ImageIcon(titleImage));
            titleImagePanel.add(titleImageLabel);
        }

            catch(FileNotFoundException ex) {
                System.out.println("Unable to find stupid file");
            }
        catch (IOException ex){
                System.out.println("error reading file");
            }

        thisFrame.setContentPane(mainMenu);
        thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame.pack();
        thisFrame.setVisible(true);
    }



    public void formatQuestion(int category){
        currentQuestion = gameController.getQuestion(currentPlayer,category);
        this.questionField.setText(currentQuestion[2]);


        ArrayList<String> options =  gameController.shuffleOptions(currentQuestion);

        this.option1.setText(options.get(0));
        this.option2.setText(options.get(1));
        this.option3.setText(options.get(2));
        this.option4.setText(options.get(3));

    }

    private void resetQuestionPanel(){
        continueButton.setEnabled(false);
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
        option1.setBackground(null);
        option2.setBackground(null);
        option3.setBackground(null);
        option4.setBackground(null);
    }

    private void questionAnswered(){
        continueButton.setEnabled(true);
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
    }

    /**
     * Constructor for the GUI
     * Initialises the gameController, question database and list model.
     */

    public GeneralGUI() {
       // thisFrame = new JFrame("GeneralGUI");
        //playerList = new JList();
        gameController = new GameController();
        //QuestionDatabase questionDatabase = new QuestionDatabase();
        playerList.setModel(gameController.getPlayers());

        /**
         * Methods for the MainMenu panel
         */

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                thisFrame.setContentPane(gameSetup);

                thisFrame.pack();
                //thisFrame.setVisible(true);

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
                //thisFrame.setVisible(true);
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
                    playerIndex = 0;
                    //JLabel playerTurn = new JLabel("Player " + currentPlayer.getName() + "'s turn.");
                    categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                    thisFrame.setContentPane(categorySelect);
                    thisFrame.pack();
                    //thisFrame.setVisible(true);
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
                //thisFrame.setVisible(true);

            }
        });

        segaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(1);
                thisFrame.pack();
                //thisFrame.setVisible(true);
            }
        });
        sonyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(2);
                thisFrame.pack();
                //thisFrame.setVisible(true);
            }
        });

        generalKnowledgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(3);
                thisFrame.pack();
                //thisFrame.setVisible(true);
            }
        });

        /**
         * Methods for questionDisplay panel
         */

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //gameController.setGuess(option1.getText());
                questionAnswered();
                if(gameController.checkAnswer(option1.getText())){
                    option1.setBackground(Color.GREEN);
                    System.out.println("correct");
                    currentPlayer.setScore(currentPlayer.getScore() + 1);


                }
                else{
                    System.out.println("wong");
                    option1.setBackground(Color.RED);
                    currentPlayer.setGameOver(true);
                }

            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //gameController.setGuess(option2.getText());
                questionAnswered();
                if(gameController.checkAnswer(option2.getText())){
                    System.out.println("correct");
                    option2.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);

                }
                else{
                    System.out.println("wong");
                    option2.setBackground(Color.RED);
                    currentPlayer.setGameOver(true);
                }
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //gameController.setGuess(option3.getText());
                questionAnswered();
                if(gameController.checkAnswer(option3.getText())){
                    System.out.println("correct");
                    option3.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);

                }
                else{
                    System.out.println("wong");
                    option3.setBackground(Color.RED);
                    currentPlayer.setGameOver(true);
                }
            }
        });
        option4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               // gameController.setGuess(option4.getText());
                questionAnswered();
                if(gameController.checkAnswer(option4.getText())){
                    System.out.println("correct");
                    option4.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);




                }
                else{
                    System.out.println("wong");
                    option4.setBackground(Color.RED);
                    currentPlayer.setGameOver(true);

                }
            }
        });

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resetQuestionPanel();
                if(currentPlayer.equals(gameController.getPlayers().lastElement())){
                    if(currentPlayer.getScore() == 15){
                        //TODO WIN SCREEN
                    }
                    else{
                        currentPlayer = gameController.getPlayers().firstElement();
                        playerIndex = 0;

                        categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                        thisFrame.setContentPane(categorySelect);
                        thisFrame.pack();
                        //thisFrame.setVisible(true);
                    }

                }
            else{
                    currentPlayer = gameController.getPlayers().elementAt(playerIndex + 1);
                    playerIndex ++;
                    categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                    thisFrame.setContentPane(categorySelect);
                    thisFrame.pack();
                    //thisFrame.setVisible(true);
                }
            }
        });
    }
}
