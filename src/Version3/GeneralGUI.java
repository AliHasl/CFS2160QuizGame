package Version3;


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
    private JList resultsList;
    private JButton half50Button;
    private JButton askTheAudienceButton;


    public static JFrame getThisFrame() {
        return thisFrame;
    }

    private static JFrame thisFrame;

    public GameController getGameController() {
        return gameController;
    }

    private GameController gameController;
    private Player currentPlayer;
    private int playerIndex;


    private String[] currentQuestion;

    /**
     * Method to start the GUI
     */

    public void display() {

        thisFrame = new JFrame();
        try {
            BufferedImage titleImage = ImageIO.read(new File("res/Bamboozle.jpg"));
            JLabel titleImageLabel = new JLabel(new ImageIcon(titleImage));
            titleImagePanel.add(titleImageLabel);
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find stupid file");
        } catch (IOException ex) {
            System.out.println("error reading file");
        }

        thisFrame.setContentPane(mainMenu);
        thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisFrame.pack();
        thisFrame.setVisible(true);
    }

    private void setHalf50Button(Player player) {
        if (player.isFiftyFifty()) {
            half50Button.setEnabled(true);
        } else {
            half50Button.setEnabled(false);
        }

    }

    public void formatQuestion(int category) {
        currentQuestion = gameController.getQuestion(currentPlayer, category);
        this.questionField.setText(currentQuestion[2]);


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
                setHalf50Button(currentPlayer);
                thisFrame.pack();
                //thisFrame.setVisible(true);

            }
        });

        segaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(1);
                setHalf50Button(currentPlayer);
                thisFrame.pack();
                //thisFrame.setVisible(true);
            }
        });
        sonyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(2);
                setHalf50Button(currentPlayer);
                thisFrame.pack();
                //thisFrame.setVisible(true);
            }
        });

        generalKnowledgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thisFrame.setContentPane(questionDisplay);
                formatQuestion(3);
                setHalf50Button(currentPlayer);
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
                if (gameController.checkAnswer(option1.getText())) {
                    option1.setBackground(Color.GREEN);
                    System.out.println("correct");
                    currentPlayer.setScore(currentPlayer.getScore() + 1);


                } else {
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
                if (gameController.checkAnswer(option2.getText())) {
                    System.out.println("correct");
                    option2.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);

                } else {
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
                if (gameController.checkAnswer(option3.getText())) {
                    System.out.println("correct");
                    option3.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);

                } else {
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
                if (gameController.checkAnswer(option4.getText())) {
                    System.out.println("correct");
                    option4.setBackground(Color.GREEN);
                    currentPlayer.setScore(currentPlayer.getScore() + 1);


                } else {
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
                if (currentPlayer.equals(gameController.getPlayers().lastElement())) {
                    if (currentPlayer.getScore() == 2) {
                        thisFrame.setContentPane(resultsPanel);
                        gameController.sortResults();
                        resultsList.setModel(gameController.getPlayers());
                        thisFrame.pack();
                        //TODO WIN SCREEN
                    } else {
                        currentPlayer = gameController.getPlayers().firstElement();
                        playerIndex = 0;

                        categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                        thisFrame.setContentPane(categorySelect);
                        thisFrame.pack();
                        //thisFrame.setVisible(true);
                    }

                } else {
                    currentPlayer = gameController.getPlayers().elementAt(playerIndex + 1);
                    playerIndex++;
                    categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                    thisFrame.setContentPane(categorySelect);
                    thisFrame.pack();
                    //thisFrame.setVisible(true);
                }
            }
        });

        half50Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rn = new Random();
                int random = rn.nextInt(4) + 1;

                int cycles = 0;
                while (cycles < 2) {
                    System.out.println(random);
                    if (random == 1) {
                        if (option1.isEnabled()) {                               //is it enabled
                            if (gameController.checkAnswer(option1.getText())) { //Is it the correct answer
                                random = rn.nextInt(4) + 1;               //if so new random int
                            } else {
                                option1.setEnabled(false);                       //If not the answer, disable button
                                random = rn.nextInt(4) + 1;              //New random number
                                cycles++;                                       //increase cycle count
                            }

                        } else {
                            random = rn.nextInt(4) + 1;                 //if disabled get new random number
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
                currentPlayer.setFiftyFifty(false);
                half50Button.setEnabled(false);
            }

        });


        askTheAudienceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PopUpAudience audience = new PopUpAudience(gameController);
                audience.pack();
                //audience.setSize(250,125);
                audience.setVisible(true);
            }
        });


        /**
         * Methods for resultsPanel
         */
        anotherGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.resetScores();
                currentPlayer = gameController.getPlayers().firstElement();
                playerIndex = 0;
                //JLabel playerTurn = new JLabel("Player " + currentPlayer.getName() + "'s turn.");
                categorySelectTitle.setText("Player " + currentPlayer.getName() + "'s turn.");
                thisFrame.setContentPane(categorySelect);
                thisFrame.pack();

            }
        });


    }
}
