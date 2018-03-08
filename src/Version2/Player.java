package Version2;

public class Player implements Comparable<Player>{

    private String name;
    private int score;
    private boolean gameOver;
    private int difficulty;

    public boolean isFiftyFifty() {
        return fiftyFifty;
    }

    public void setFiftyFifty(boolean fiftyFifty) {
        this.fiftyFifty = fiftyFifty;
    }

    private boolean fiftyFifty;

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }


    public int getDifficulty() {
        return difficulty;
    }

    public String resultString(){

        return  "Player" + name + " " + score;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.difficulty = 0;
        this.gameOver = false;
        this.fiftyFifty = true;
    }

    public String getName() {
        return name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int compareTo(Player player){
        if(player.score > this.score) {
            return 1;
        }
        else if(player.score < this.score){
            return -1;
        }
        else{
            return 0;
        }
    }
}
