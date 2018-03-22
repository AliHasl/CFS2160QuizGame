package Version4;
/**
 * Created by u1773783 on 20/03/2018.
 */
import static org.junit.Assert.*;

public class PlayerTest {


    @org.junit.Test
    public void isAskAudience() throws Exception {
        Player testPlayer = new Player("testPlayer");
        assertTrue(testPlayer.isAskAudience());

    }

    @org.junit.Test
    public void setAskAudience() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.setAskAudience(false);
        assertFalse(testPlayer.isAskAudience());
    }

    @org.junit.Test
    public void isHalfFifty() {
        Player testPlayer = new Player("testPlayer");
        assertTrue(testPlayer.isHalfFifty());
    }

    @org.junit.Test
    public void setHalfFifty() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.setHalfFifty(false);
        assertFalse(testPlayer.isHalfFifty());

    }

    @org.junit.Test
    public void isPlayerOut() {
        Player testPlayer = new Player("testPlayer");
        assertFalse(testPlayer.isPlayerOut());
    }

    @org.junit.Test
    public void setPlayerOut() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.setPlayerOut(true);
        assertTrue(testPlayer.isPlayerOut());
    }

    @org.junit.Test
    public void getName() {
        Player testPlayer = new Player("testPlayer");
        assertEquals("testPlayer", testPlayer.getName());
        assertNotEquals("",testPlayer.getName());
    }

    @org.junit.Test
    public void getScore() {
        Player testPlayer = new Player("testPlayer");
        assertEquals(0,testPlayer.getScore());
    }

    @org.junit.Test
    public void setScore() {
        Player testPlayer = new Player("testPlayer");
        testPlayer.setScore(1);
        assertEquals(1,testPlayer.getScore());
    }

}