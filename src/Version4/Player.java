package Version4;

public class Player implements Comparable<Player>{

    private String name;
    private int score;
    private boolean playerOut;
    private boolean fiftyFifty;
    private boolean askAudience;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.askAudience = true;
        this.playerOut = false;
        this.fiftyFifty = true;
    }

    public boolean isAskAudience() {
        return askAudience;
    }

    public void setAskAudience(boolean askAudience) {
        this.askAudience = askAudience;
    }

    public boolean isHalfFifty() {
        return fiftyFifty;
    }

    public void setHalfFifty(boolean fiftyFifty) {
        this.fiftyFifty = fiftyFifty;
    }

    public void setPlayerOut(boolean playerOut) {
        this.playerOut = playerOut;
    }

    public boolean isPlayerOut() {
        return playerOut;
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

    @Override
    public String toString() {
        return name;
    }

    @Override
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
