package Version2;

import javax.swing.*;

public class GameController extends DefaultListModel<Player> {

    private Player player;
    private DefaultListModel<Player> players;
    private QuestionDatabase questionDatabase;
    private int guess;
    private String[] currentQuestion;

    public void setGuess(int guess) {
        this.guess = guess;
    }


    public GameController() {
        players = new DefaultListModel<Player>();
        questionDatabase = new QuestionDatabase();
        Player bob = new Player("bob");
        players.addElement(bob);

    }

    public boolean checkAnswer(QuestionDatabase question){
        if(guess == (int)question[5])
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



    public String[] presentQuestion(Player player, int category) {
        //player.getScore();
        if (category == 0) {
            currentQuestion = questionDatabase.getQuestion1();
            return currentQuestion;
        } else if (category == 1) {
            currentQuestion = questionDatabase.getQuestion2();
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
