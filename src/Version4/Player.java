package Version4;

public class Player implements Comparable<Player>{

    private String name;
    private int score;

    public boolean isPlayerOut() {
        return playerOut;
    }

    private boolean playerOut;
    private boolean fiftyFifty;
    private boolean askAudience;

    public boolean isAskAudience() {
        return askAudience;
    }

    public void setAskAudience(boolean askAudience) {
        this.askAudience = askAudience;
    }



    public boolean isFiftyFifty() {
        return fiftyFifty;
    }

    public void setFiftyFifty(boolean fiftyFifty) {
        this.fiftyFifty = fiftyFifty;
    }

    public String resultString(){

        return  "Player" + name + " " + score;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setPlayerOut(boolean playerOut) {
        this.playerOut = playerOut;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.askAudience = true;
        this.playerOut = false;
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
