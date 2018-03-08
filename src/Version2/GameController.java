package Version2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GameController extends DefaultListModel<Player> {

    private Player player;
    private DefaultListModel<Player> players;
    private QuestionDatabase questionDatabase;




    private String[] currentQuestion;


    public ArrayList<String> getOptions() {
        return options;
    }

    private ArrayList<String> options;



    public void setCurrentQuestion(String[] currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public GameController() {
        players = new DefaultListModel<Player>();
        questionDatabase = new QuestionDatabase();
        questionDatabase.setAllCategoryQuestions();
        Player bob = new Player("bob");
        players.addElement(bob);

    }

    public boolean checkAnswer(String guess){
        if(guess.equals(currentQuestion[3]))
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

    public void resetScores(){
        for(int i = 0; i < players.size();i++){
            this.players.getElementAt(i).setScore(0);
            this.players.getElementAt(i).setDifficulty(0);
        }
    }

public void sortResults(){
    ArrayList<Player> list = new ArrayList<>();

    for(int i = 0; i < this.players.size(); i++)
    {
        list.add(players.getElementAt(i));
        this.players.remove(i);
    }

    Collections.sort(list);
        for(Player player: list){
            this.players.addElement(player);
        }
    }

public ArrayList<String> shuffleOptions(String[] currentQuestion){
        options = new ArrayList<>();
        options.add(currentQuestion[3]);
        options.add(currentQuestion[4]);
        options.add(currentQuestion[5]);
        options.add(currentQuestion[6]);
        Collections.shuffle(options);
        return options;

}


    public String[] getQuestion(Player player, int category) {

        currentQuestion = questionDatabase.getQuestionFromCategory(category, player.getDifficulty());
        return currentQuestion;
    }




}
