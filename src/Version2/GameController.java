package Version2;

import javax.swing.*;

public class GameController extends DefaultListModel<Player> {

    private Player player;
    private DefaultListModel<Player> players;

    public GameController() {
        players = new DefaultListModel<Player>();
        Player bob = new Player("bob");
        players.addElement(bob);


    }

    public DefaultListModel<Player> getPlayers() {
        return players;
    }

    public void addToTeam(Player player){

        this.players.addElement(player);
    }

    public void removeFromTeam(int selectionNumber){

        this.players.removeElementAt(selectionNumber);
    }

}
