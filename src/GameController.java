import javax.swing.*;

public class GameController extends DefaultListModel<Player> {

    private Player player;
    private DefaultListModel<Player>players;

    public GameController() {
        DefaultListModel<Player> players = new DefaultListModel<Player>();

    }

    public DefaultListModel<Player> getPlayers() {
        return players;
    }

    public void addToTeam(){
        this.players.addElement(player);
    }

    public void removeFromTeam(){
        this.players.addElement(player);
    }

}
