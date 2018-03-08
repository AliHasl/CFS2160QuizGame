package Version2;

public class Player {

    private String name;
    private int score;
    private boolean gameOver;

    public int getDifficulty() {
        return difficulty;
    }

    private int difficulty;

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
}
