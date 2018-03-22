package Version4;
/**
 * Created by u1773783 on 20/03/2018.
 */
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
import java.util.Random;

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
    private JPanel resultsPanel;
    private JButton anotherGameButton;
    private JButton mainMenuButton;
    private JButton half50Button;
    private JButton askTheAudienceButton;
    private JList moneyProgress;
    private JPanel busterFaceCat;
    private JPanel catTopPanel;
    private JPanel resultDisplay;
    private JLabel resultsTitle;
    private JFrame thisFrame;
    private GameController gameController;
    private Player currentPlayer;
    private String[] currentQuestion;


    /**
     * Constructor for the GUI
     * Initialises the gameController, question database and list model.
     */

    public GeneralGUI() {

        gameController = new GameController();
        playerList.setModel(gameController.getPlayers());
        moneyProgress.setModel(gameController.getMoneyValues());

        /**
         * Methods for the MainMenu panel
         */

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(gameSetup);
                thisFrame.pack();
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
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(nameField.getText().equals("")){

                    JOptionPane.showMessageDialog(thisFrame, "Please enter a name.");
                }
                else {
                    Player player = new Player(nameField.getText());
                    nameField.setText(null);
                    gameController.addToTeam(player);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectionNumber = playerList.getSelectedIndex();
                if (selectionNumber == -1) {
                    JOptionPane.showMessageDialog(thisFrame, "Please select a player to remove.");
                } else {
                    gameController.removeFromTeam(selectionNumber);
                }
            }
        });

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (gameController.getPlayers().size() == 0) {
                    JOptionPane.showMessageDialog(thisFrame, "You must create at least one player to proceed.");
                } else {
                    currentPlayer = gameController.quizStart();
                    moneyProgress.setEnabled(false);
                    categorySelectTitle.setForeground(Color.BLUE);
                    categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                    moneyProgress.setSelectedIndex((gameController.getMoneyValues().size() - currentPlayer.getScore()) - 1);
                    thisFrame.setContentPane(categorySelect);
                    thisFrame.pack();
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
                setLifelineButtons(currentPlayer);
                thisFrame.pack();


            }
        });

        segaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(1);
                setLifelineButtons(currentPlayer);
                thisFrame.pack();

            }
        });
        sonyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(2);
                setLifelineButtons(currentPlayer);
                thisFrame.pack();

            }
        });

        generalKnowledgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(3);
                setLifelineButtons(currentPlayer);
                thisFrame.pack();


            }
        });

        /**
         * Methods for questionDisplay panel
         */

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                questionAnswered();
                if (gameController.checkAnswer(option1.getText())) {
                    option1.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);


                } else {

                    option1.setBackground(Color.RED);
                    currentPlayer.setPlayerOut(true);
                    gameController.addToRankingsList(currentPlayer);
                    gameController.kickPlayer();
                }

            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                questionAnswered();
                if (gameController.checkAnswer(option2.getText())) {
                    option2.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);

                } else {
                    option2.setBackground(Color.RED);
                    currentPlayer.setPlayerOut(true);
                    gameController.addToRankingsList(currentPlayer);
                    gameController.kickPlayer();
                }
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                questionAnswered();
                if (gameController.checkAnswer(option3.getText())) {
                    option3.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);

                } else {
                    option3.setBackground(Color.RED);
                    currentPlayer.setPlayerOut(true);
                    gameController.addToRankingsList(currentPlayer);
                    gameController.kickPlayer();
                }
            }
        });

        option4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                questionAnswered();
                if (gameController.checkAnswer(option4.getText())) {
                    option4.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);
                }

                else {
                    option4.setBackground(Color.RED);
                    currentPlayer.setPlayerOut(true);
                    gameController.addToRankingsList(currentPlayer);
                    gameController.kickPlayer();
                }
            }
        });

        //Continue button controls gameflow. Here end game results are checked diverting flow to
        //the next player or to the results screen.
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resetQuestionPanel();
                currentPlayer = gameController.endTurn();
                if(gameController.checkEndOfGame()) {
                    thisFrame.setContentPane(resultsPanel);
                    gameController.sortRankings();
                    resultsTitle.setText("Game Over! How much did you win?");
                    resultDisplay.setLayout(new BoxLayout(resultDisplay,1));

                    //Formats the results table to put players in order of winnings. BoxLayout is similar to flow but
                    //puts JLables on top of each other.
                    for (int i = 0; i < gameController.getPlayerRankings().size();i++) {

                        System.out.println(gameController.getPlayers().getElementAt(i).getName());
                        System.out.println(gameController.getPlayers().getElementAt(i).getScore());
                        JLabel temp = new JLabel();
                        temp.setText("          " + (i +1) +". " + gameController.getPlayerRankings().get(i).getName() + " - " +
                                gameController.getMoneyValue((15 - gameController.getPlayerRankings().get(i)
                                        .getScore())) + "\n");
                        temp.setFont(gameController.getTeletext());
                        temp.setForeground(Color.WHITE);
                        resultDisplay.add(temp);
                    }
                    thisFrame.pack();
                }

                else{
                    categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                    moneyProgress.setSelectedIndex((gameController.getMoneyValues().size() - currentPlayer.getScore()) - 1);
                    thisFrame.setContentPane(categorySelect);
                    thisFrame.pack();
                }
            }
        });

        half50Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                halfFifty();
            }

        });

        askTheAudienceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PopUpAudience audience = new PopUpAudience(gameController);
                audience.pack();
                audience.setVisible(true);
                askTheAudienceButton.setEnabled(false);
                currentPlayer.setAskAudience(false);
            }
        });

        /**
         * Methods for resultsPanel
         */
        anotherGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.resetScores();
                resultDisplay.removeAll();
                currentPlayer = gameController.getPlayers().firstElement();
                moneyProgress.setSelectedIndex((gameController.getMoneyValues().size() - currentPlayer.getScore()) - 1);
                categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                thisFrame.setContentPane(categorySelect);
                thisFrame.pack();


            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameController.resetGameController();
                resultDisplay.removeAll();
                thisFrame.setContentPane(mainMenu);
                thisFrame.pack();
            }
        });
    }

    /**
     * Method to start the GUI
     */

    public void display() {
        thisFrame = new JFrame("Bamboozle!");

        //Sorts buttons into arrays to set the imported Font
        JButton[] buttons = new JButton[]{startButton, backButton, startGameButton,addButton,removeButton,nintendoButton,
                segaButton,sonyButton,generalKnowledgeButton,option1,option2, option3, option4, half50Button,askTheAudienceButton,
                anotherGameButton,mainMenuButton, continueButton};

        for (JButton jbut: buttons){
            jbut.setFont(gameController.getTeletext());
        }
        //Sorts JLabels into arrays to set the imported Font
        JLabel[] jLabels = new JLabel[]{categorySelectTitle, questionField,resultsTitle};
        for (JLabel jlb: jLabels){
            jlb.setFont(gameController.getTeletext());
        }
        //Sorts JLists into arrays to set the imported font.
        JList[] jLists = new JList[]{moneyProgress,playerList};
        for(JList jLt: jLists){
            jLt.setFont(gameController.getTeletext());
        }

        //Sets the correct sizes for the frame.
        thisFrame.setSize(GeneralGUI.getMinimumSize());
        thisFrame.setMinimumSize(categorySelect.getMinimumSize());
        thisFrame.setBackground(Color.BLACK);
        thisFrame.setContentPane(mainMenu);
        titleImagePanel.setSize(titleImagePanel.getMinimumSize());
        thisFrame.pack();

        //Sets the images up for later
        try {
            BufferedImage brianImage = ImageIO.read(new File("res/BamboozleFace.jpg"));
            Image BamberImage = brianImage.getScaledInstance(360, 288, Image.SCALE_DEFAULT);
            JLabel bamberFaceLabel = new JLabel(new ImageIcon(BamberImage));
            busterFaceCat.add(bamberFaceLabel);

            BufferedImage topImage = ImageIO.read(new File("res/BamboozleTop.jpg"));
            Image elongatedImage = topImage.getScaledInstance(800, 20, Image.SCALE_DEFAULT);
            JLabel catTopImageLabel = new JLabel(new ImageIcon(elongatedImage));
            catTopPanel.add(catTopImageLabel);

            BufferedImage titleImage = ImageIO.read(new File("res/Bamboozle.jpg"));
            Image stretchedImage = titleImage.getScaledInstance(titleImagePanel.getWidth(), titleImagePanel.getHeight(), Image.SCALE_DEFAULT);
            JLabel titleImageLabel = new JLabel(new ImageIcon(stretchedImage));

            titleImagePanel.add(titleImageLabel);
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find stupid file");
        } catch (IOException ex) {
            System.out.println("error reading file");
        }
        thisFrame.setContentPane(mainMenu);
        thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame.setVisible(true);
    }

    private void setLifelineButtons(Player player) {
        if (player.isHalfFifty()) {
            half50Button.setEnabled(true);
        } else {
            half50Button.setEnabled(false);
        }
        if (player.isAskAudience()){
            askTheAudienceButton.setEnabled(true);
        }
        else{
            askTheAudienceButton.setEnabled(false);
        }
    }

    //Sets the text for JLabels and JButtons to that of the current question
    public void formatQuestion(int category) {
        currentQuestion = gameController.getQuestion(category);
        questionField.setText("<html>"+currentQuestion[2]+"</html>");
        ArrayList<String> options = gameController.shuffleOptions(currentQuestion);
        option1.setText(options.get(0));
        option2.setText(options.get(1));
        option3.setText(options.get(2));
        option4.setText(options.get(3));
    }

    private void resetQuestionPanel() {
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

    private void questionAnswered() {
        continueButton.setEnabled(true);
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
    }

    //Method for running HalfFifty lifeLine.
    private void halfFifty(){
        Random rn = new Random();
        int random = rn.nextInt(4) + 1;


        //Sets cycles to pick two incorrect answers.
        int cycles = 0;
        while (cycles < 2) {
            System.out.println(random);
            if (random == 1) {
                if (option1.isEnabled()) {
                    if (gameController.checkAnswer(option1.getText())) {
                        random = rn.nextInt(4) + 1;
                    } else {
                        option1.setEnabled(false);
                        random = rn.nextInt(4) + 1;
                        cycles++;
                    }

                } else {
                    random = rn.nextInt(4) + 1;
                }
            } else if (random == 2) {
                if (option2.isEnabled()) {
                    if (gameController.checkAnswer(option2.getText())) {
                        random = rn.nextInt(4) + 1;
                    } else {
                        option2.setEnabled(false);
                        random = rn.nextInt(4) + 1;
                        cycles++;
                    }
                } else {
                    random = rn.nextInt(4) + 1;
                }
            } else if (random == 3) {
                if (option3.isEnabled()) {
                    if (gameController.checkAnswer(option3.getText())) {
                        random = rn.nextInt(4) + 1;
                    } else {
                        option3.setEnabled(false);
                        random = rn.nextInt(4) + 1;
                        cycles++;
                    }
                } else {
                    random = rn.nextInt(4) + 1;
                }
            } else if (random == 4) {

                if (option4.isEnabled()) {
                    if (gameController.checkAnswer(option4.getText())) {
                        random = rn.nextInt(4) + 1;
                    } else {
                        option4.setEnabled(false);
                        random = rn.nextInt(4) + 1;
                        cycles++;
                    }
                } else {
                    random = rn.nextInt(4) + 1;
                }
            }

        }
        currentPlayer.setHalfFifty(false);
        half50Button.setEnabled(false);
    }
}
