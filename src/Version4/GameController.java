package Version4;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GameController extends DefaultListModel<Player> {


    private DefaultListModel<Player> players;

    public ArrayList<Player> getPlayerRankings() {
        return playerRankings;
    }

    private ArrayList<Player> playerRankings;
    private QuestionDatabase questionDatabase;
    private String[] currentQuestionOptions;
    private int difficulty;
    private int playersKicked;
    private int playersRemaining;

    public Font getTeletext() {
        return teletext;
    }

    private Font teletext;


    private String[] money;
    public DefaultListModel<String> getMoneyValues() {
        return moneyValues;
    }

    private DefaultListModel<String> moneyValues;

    public String getMoneyValue(int i) {
        return money[i];
    }

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
        Player fred = new Player("fred");
        fred.setScore(14);
        bob.setScore(14);
        players.addElement(bob);
        players.addElement(fred);
        playerRankings = new ArrayList<>();
        options = new ArrayList<>();
        playerIndex = 0;
        difficulty = 0;
        playersKicked = 0;
        moneyValues = new DefaultListModel<>();
        money = new String[]{"$1 Zillion", "$500,000", "$250,000", "$125,000", "$64,000", "$32,000", "$16,000", "$8,000",
                "$4,000", "$2,000", "$1,000", "$500", "$300", "$200", "$100", "$0"};
        for (int i = 0; i < money.length; i++) {
            moneyValues.addElement(money[i]);

        }

        try {
            File tele = new File("res/teletext_regular.ttf");

            teletext = Font.createFont(Font.TRUETYPE_FONT, tele);


        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find stupid file");

        }catch(FontFormatException ex){
            System.out.println("Error with Font");

        }
        catch (IOException ex) {
            System.out.println("error reading file");
        }


        System.out.println(teletext);

        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(teletext);
        teletext = teletext.deriveFont(30F);
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
            this.players.getElementAt(i).setPlayerOut(false);
            this.players.getElementAt(i).setFiftyFifty(true);
            this.players.getElementAt(i).setAskAudience(true);

        }
        currentPlayer = players.get(playerIndex);
    }

    public void addToResultsList(Player currentPlayer){
        playerRankings.add(currentPlayer);
    }

    public void sortResults() {




        Collections.sort(playerRankings);



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

    public Player endTurn() {
        playersRemaining = players.size() - playersKicked;

        if(currentPlayer.getScore() == 15){
            playerRankings.add(currentPlayer);

        }

        if (playersKicked == players.size() || playerRankings.size() == players.size()) {
            endGame = true;
            return null;

        }


        else{
            playerIndex ++;
            playerIndex = playerIndex % players.size();
            }

        while (players.elementAt(playerIndex).isPlayerOut() ) {
            playerIndex ++;
            playerIndex = playerIndex % players.size();

        }

        currentPlayer = players.elementAt(playerIndex);

        if(currentPlayer.getScore() >= 5 && currentPlayer.getScore() < 10) {
            difficulty = 1;
        }
        if(currentPlayer.getScore() >=10)
        {
            difficulty = 2;
        }
        return currentPlayer;


    }



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
