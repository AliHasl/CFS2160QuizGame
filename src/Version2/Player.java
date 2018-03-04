package Version2;

public class Player {

    private String name;
    private int score;

    @Override
    public String toString() {
        return name;
    }

    public Player(String name) {
        this.name = name;
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
