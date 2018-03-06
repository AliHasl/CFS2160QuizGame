package Version2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameController extends DefaultListModel<Player> {

    private Player player;
    private DefaultListModel<Player> players;
    private QuestionDatabase questionDatabase;
    private String guess;
    private String[] currentQuestion;
    private String currentAnswer;

    public ArrayList<String> getOptions() {
        return options;
    }

    private ArrayList<String> options;


    public void setGuess(String attempt) {
        this.guess = attempt;
    }


    public GameController() {
        players = new DefaultListModel<Player>();
        questionDatabase = new QuestionDatabase();
        Player bob = new Player("bob");
        players.addElement(bob);

    }

    public boolean checkAnswer(){
        if(guess == currentQuestion[1])
            return true;
        else
            return false;
    }

    public DefaultListModel<Player> getPlayers() {
        return players;
    }

    public void addToTeam(Player player) {

        this.players.addElement(player);
    }

    public void removeFromTeam(int selectionNumber) {

        this.players.removeElementAt(selectionNumber);
    }

public ArrayList<String> shuffleOptions(){
        options = new ArrayList<>();
        options.add(currentQuestion[1]);
        options.add(currentQuestion[2]);
        options.add(currentQuestion[3]);
        options.add(currentQuestion[4]);
        Collections.shuffle(options);
        return options;

}


    public String[] getQuestion(Player player, int category) {
        //player.getScore();
        if (category == 0) {
            currentQuestion = questionDatabase.getQuestion1();
            currentAnswer = questionDatabase.getQuestion1()[1];
            return currentQuestion;
        } else if (category == 1) {
            currentQuestion = questionDatabase.getQuestion2();
            currentAnswer = questionDatabase.getQuestion2()[1];
            return currentQuestion;
        }

        else if (category == 2){
            return questionDatabase.getQuestion1();
        }
        else{
            return questionDatabase.getQuestion1();
        }

    }




}
