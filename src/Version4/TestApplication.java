package Version4;

/**
 * Created by u1773783 on 20/03/2018.
 */
public class TestApplication {

    private static void playerCreationTest(){
        System.out.println("Running playerCreation Test");
        Player testPlayer = new Player("TESTBOT - 5000");
        System.out.println("Name: " + testPlayer.getName());
        System.out.println("Initial Score: " + testPlayer.getScore());
        System.out.println("Initial AskAudience lifeline Status: " + testPlayer.isAskAudience());
        System.out.println("Initial Half:50 lifeline Status: " + testPlayer.isHalfFifty());
        System.out.println("Initial is player out status: " + testPlayer.isPlayerOut());

        if(testPlayer.getName() == "TESTBOT - 5000" && testPlayer.getScore() == 0 && testPlayer.isAskAudience() == true
                && testPlayer.isHalfFifty() == true && testPlayer.isPlayerOut() == false) {
            System.out.println("TESTBOT-5000 APPROVES PLAYER CREATION");
        }
            else{
                System.out.println("ERROR - TESTBOT - ERROR");
                throw new StackOverflowError();
            }
        System.out.println();
        }

        private static void playerModificationTest(){
        System.out.println("Running playerModification Test");
        Player testPlayer = new Player("TESTBOT - 5000");
        System.out.println("Adding one to Score" );
        testPlayer.setScore(1);
        System.out.println("New Player score: " + testPlayer.getScore());
        System.out.println("Reversing player booleans");
        testPlayer.setHalfFifty(false);
        testPlayer.setAskAudience(false);
        testPlayer.setPlayerOut(true);

        System.out.println("Half:Fifty: " + testPlayer.isHalfFifty());
        System.out.println("AskAudience: " + testPlayer.isAskAudience());
        System.out.println("PlayerOut: " + testPlayer.isPlayerOut());

        if(testPlayer.getScore() == 1 && testPlayer.isHalfFifty() == false && testPlayer.isAskAudience() == false
                &&testPlayer.isPlayerOut() == true) {
            System.out.println("TESTBOT-5000 APPROVES PLAYER MODIFICATION");
        }
        else {
            System.out.println("ERROR - TESTBOT - ERROR");
            throw new StackOverflowError();
        }
        }

        private static void testGUI(){
            GameController gameController = new GameController();
        }


    public static void main(String[] args) {
        System.out.println( "  ______________ \n" +
                            " |              |\n" +
                            " |   O     O    |\n" +
                            " |  __________  |\n" +
                            " | |/\\/\\/\\/\\/\\| |\n" +
                            " | |/\\/\\/\\/\\/\\| |\n" +
                            "  --------------\n" +
        "TESTBOT - 5000: Testing Application\n");


        playerCreationTest();
        playerModificationTest();
        testGUI();
    }



}
