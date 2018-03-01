import javax.swing.*;

public class GameController {

    private Player player;
    private DefaultListModel<Player>players;

    public GameController() {
        DefaultListModel<Player> players = new DefaultListModel<Player>();
        new MainMenu().MainMenu();
    }

    public void addToTeam(){
        this.players.addElement(player);
    }

    public void removeFromTeam(){
        this.players.addElement(player);
    }

}
