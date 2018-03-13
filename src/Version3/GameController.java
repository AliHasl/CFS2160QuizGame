package Version3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController extends DefaultListModel<Player> {


    private DefaultListModel<Player> players;
    private QuestionDatabase questionDatabase;
    private String[] currentQuestionOptions;
    private int difficulty;
    private int playersKicked;

    public DefaultListModel<String> getMoneyValues() {
        return moneyValues;
    }

    private DefaultListModel<String> moneyValues;


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private Player currentPlayer;

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    private int playerIndex;
    private boolean endGame;


    private String[] currentQuestion;
    private ArrayList<String> options;

    public String[] getCurrentQuestionOptions() {
        return currentQuestionOptions;
    }

    public void setCurrentQuestionOptions(String[] currentQuestionOptions) {
        this.currentQuestionOptions = currentQuestionOptions;
    }


    public void resetGameController() {
        players.clear();
        difficulty = 0;
        playersKicked = 0;
        endGame = false;
    }

    public String[] getCurrentQuestion() {
        return currentQuestion;
    }

    public ArrayList<String> getOptions() {
        return options;
    }


    public void setCurrentQuestion(String[] currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public GameController() {
        players = new DefaultListModel<Player>();
        questionDatabase = new QuestionDatabase();
        questionDatabase.setAllCategoryQuestions();
        Player bob = new Player("bob");
        players.addElement(bob);
        options = new ArrayList<>();
        playerIndex = 0;
        difficulty = 0;
        playersKicked = 0;
        moneyValues = new DefaultListModel<>();
        String[] money = {"£1 Zillion", "£500,000", "£250,000", "£125,000", "£64,000", "£32,000", "£16,000", "£8,000", "£4,000", "£2,000", "£1,000", "£500", "£300", "£200", "£100"};
        for (int i = 0; i < money.length; i++) {
            moneyValues.addElement(money[i]);
        }
    }

    public boolean checkAnswer(String guess) {
        if (guess.equals(currentQuestion[3]))
            return true;
        else
            return false;
    }

    public DefaultListModel<Player> getPlayers() {
        return players;
    }

    public Player quizStart() {
        currentPlayer = players.firstElement();
        return currentPlayer;
    }

    public void addToTeam(Player player) {

        this.players.addElement(player);
    }

    public void removeFromTeam(int selectionNumber) {

        this.players.removeElementAt(selectionNumber);
    }

    public void resetScores() {
        difficulty = 0;
        playersKicked = 0;
        endGame = false;
        playerIndex = 0;
        for (int i = 0; i < players.size(); i++) {
            this.players.getElementAt(i).setScore(0);

        }
    }

    public void sortResults() {
        ArrayList<Player> list = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            list.add(players.getElementAt(i));
            players.remove(i);
        }

        Collections.sort(list);
        for (Player player : list) {
            players.addElement(player);
        }
    }

    public ArrayList<String> shuffleOptions(String[] currentQuestion) {
        options.clear();
        options.add(currentQuestion[3]);
        options.add(currentQuestion[4]);
        options.add(currentQuestion[5]);
        options.add(currentQuestion[6]);
        Collections.shuffle(options);
        return options;

    }

    public void endTurn() {
        if (playersKicked == players.size()) {
            endGame = true;
        } else if (currentPlayer.equals((players.lastElement()))) {
            playerIndex = 0;


        } else {
            playerIndex++;
        }
        while (players.elementAt(playerIndex).isPlayerOut() && !players.elementAt(playerIndex).equals(players.lastElement())) {
            playerIndex++;

        }
        if (currentPlayer.equals((players.lastElement()))) {
            playerIndex = 0;
        }
        currentPlayer = players.elementAt(playerIndex);


    }

        /*
        if (currentPlayer.equals(players.lastElement())) {

            if (currentPlayer.getScore() == 1) {

                difficulty ++;

            }

            if (currentPlayer.getScore() == 2) {

                difficulty ++;

            }

            if (currentPlayer.getScore() == 3) {

                endGame = true;

            }


            else {
                if(players.firstElement().isPlayerOut()){
                    playerIndex = 1;
                    endTurn();
                }
                else {
                    currentPlayer = players.firstElement();
                    playerIndex = 0;
                }
            }

        } else {
            if(players.elementAt(playerIndex + 1).isPlayerOut()) {
                playerIndex++;
                endTurn();
            }
            else {
                currentPlayer = players.elementAt(playerIndex + 1);

                playerIndex++;
            }
        }
        */


    public void kickPlayer(){
        playersKicked ++;
    }

    public boolean checkEndOfGame(){
        if(playersKicked == players.size())
        {
            endGame = true;
        }

        if(endGame == true){
            return true;
        }
        else{
            return false;
        }
    }

    public String[] getQuestion( int category) {

        currentQuestion = questionDatabase.getQuestionFromCategory(category, difficulty);
        return currentQuestion;
    }


}
