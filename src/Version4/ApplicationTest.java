package Version4;
/**
 * Created by u1773783 on 20/03/2018.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApplicationTest {

    private static void questionDatabaseTest(){
        QuestionDatabase questionDatabase = new QuestionDatabase();
        questionDatabase.setAllCategoryQuestions();
        String[] testQuestionParts1 = new String[7];
        String[] testQuestionParts2 = new String[7];
        File file = new File("res/Questions.txt");
        try {
            Scanner fileIn = new Scanner(file);
            int count = 0;
            while(count < 3){
                testQuestionParts1 = fileIn.nextLine().split(",");
                count++;
            }
            while(count < 12){
                testQuestionParts2 = fileIn.nextLine().split(",");
                count++;
            }
            fileIn.close();

        }
        catch (FileNotFoundException ex){
            System.out.println("TESTBOT-5000 cannot find File!");
        }

        System.out.println("Printing question from line 3");
        System.out.println("Expected: What was Nintendo's most popular top down adventure game?");
        System.out.println("Observed: "+testQuestionParts1[2]);
        System.out.println("Printing answer from question 12");
        System.out.println("Expected: 1889");
        System.out.println("Observed: " + testQuestionParts2[3]);

        if(testQuestionParts1[2].equals("What was Nintendo's most popular top down adventure game?") && testQuestionParts2[3].equals("1889"))
        {
            System.out.println("TESTBOT-5000 APPROVES FILE READING");
            testBotApproves();
        }
        else{
            System.out.println("ERROR - TESTBOT - ERROR");
            throw new StackOverflowError();
        } System.out.println();
    }

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
            testBotApproves();
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
            testBotApproves();
        }
        else {
            System.out.println("ERROR - TESTBOT - ERROR");
            throw new StackOverflowError();
        }
            System.out.println();
        }



        private static void testBotApproves(){
            System.out.println( "                   _ \n" +
                    "  ______________  | |\n" +
                    " |              | | |___\n" +
                    " |   O     O    | |  ___)\n" +
                    " |  __________  | |  ___)\n" +
                    " | |/\\/\\/\\/\\/\\| | |  ___)\n" +
                    " | |/\\/\\/\\/\\/\\| | |  ___)\n" +
                    "  --------------  ------\n");
        }

    public static void main(String[] args) {
        System.out.println( "  ______________ \n" +
                            " |              |\n" +
                            " |   O     O    |\n" +
                            " |  __________  |\n" +
                            " | |/\\/\\/\\/\\/\\| |\n" +
                            " | |/\\/\\/\\/\\/\\| |\n" +
                            "  --------------\n" +
        "TESTBOT - 5000: TESTING APPLICATION\n");



        playerCreationTest();
        playerModificationTest();
        questionDatabaseTest();

    }



}
