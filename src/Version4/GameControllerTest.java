package Version4;
/**
 * Created by u1773783 on 20/03/2018.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest {

    @Test
    public void resetGameController() {
        //Sets up conditions for initial test
        GameController testGameController = new GameController();
        Player testPlayer = new Player("testPlayer1");
        testGameController.addToTeam(testPlayer);
        testGameController.addToRankingsList(testPlayer);
        testGameController.setDifficulty(1);
        testGameController.kickPlayer();
        testGameController.setEndGame(true);

        //Tests initial conditions are valid
        assertEquals("testPlayer1",testGameController.getPlayers().get(0).getName());
        assertEquals("testPlayer1",testGameController.getPlayerRankings().get(0).getName());
        assertEquals(1,testGameController.getDifficulty());
        assertEquals(1,testGameController.getPlayersKicked());
        assertTrue(testGameController.isEndGame());

        //Runs the method to be tested
        testGameController.resetGameController();

        //Tests the method produces the desired outcome.
        assertTrue(testGameController.getPlayers().isEmpty());
        assertTrue(testGameController.getPlayerRankings().isEmpty());
        assertEquals(0,testGameController.getDifficulty());
        assertEquals(0,testGameController.getPlayersKicked());
        assertFalse(testGameController.isEndGame());
    }

}