package Version2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionDatabase {
    private ArrayList<String[]> category1;
    private ArrayList<String[]> category2;
    private ArrayList<String[]> category3;
    private ArrayList<String[]> category4;


    private String[] question1 = {"What is my name?", "bib", "bob", "fred", "Alistair"};
    private int answer1 = 4;
    private String[] question2 = {"Hello", "how are you", "my", "name", "is"};
    private int answer2 = 1;
    private File file;


    public String[] getQuestion1() {
        return question1;
    }


    public String[] getQuestion2() {
        return question2;
    }



    public static void getCategoryQuestions(){
        try {
            //String fileName = "src/Version2/Questions.txt";
            //FileReader reader = new FileReader(fileName);
            File file = new File("src/Version2/Questions.txt");
            //Scanner fileIn = new Scanner(new File("Questions.txt"));
            Scanner fileIn = new Scanner(file);
            //String[] questionParts;// = fileIn.nextLine().split(",");
            ArrayList<String[]> category1 = new ArrayList<String[]>();
            ArrayList<String[]> category2 = new ArrayList<String[]>();
            ArrayList<String[]> category3 = new ArrayList<String[]>();
            ArrayList<String[]> category4 = new ArrayList<String[]>();
            for (int i = 0; i < 3; i++) {
                String[] questionParts;
                questionParts = fileIn.nextLine().split(",");
                if (questionParts[0].equals("0")) {
                    category1.add(questionParts);
                } else if (questionParts[0].equals("1")) {
                    category2.add(questionParts);
                } else if (questionParts[0].equals("2"))
                    category3.add(questionParts);
            else{
                category4.add(questionParts);
                }
        }
            //category2.add(questionparts);
            System.out.println(category1.get(0)[2]);
            System.out.println(category2.get(0)[2]);
            System.out.println(category1.get(1)[2]);
            //FileReader r = new FileReader("src/Version2/Questions.txt");

            //System.out.println(fileIn.nextLine());

            //System.out.println(new File(".").getAbsolutePath());
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to find stupid file");
        }
        catch (IOException ex){
            System.out.println("error reading file");
        }
    }


    public static void main(String[] args) {
        getCategoryQuestions();

    }

}
