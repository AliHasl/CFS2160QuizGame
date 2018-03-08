package Version2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuestionDatabase {
    private ArrayList<String[]> category1;
    private ArrayList<String[]> category2;
    private ArrayList<String[]> category3;
    private ArrayList<String[]> category4;
    private ArrayList<String[]> currentCategory;
    private String[] currentQuestion;


    public QuestionDatabase() {

        category1 = new ArrayList<String[]>();
        category2 = new ArrayList<String[]>();
        category3 = new ArrayList<String[]>();
        category4 = new ArrayList<String[]>();

    }

    public String[] getQuestionFromCategory(int category, int difficulty) {

        int count = 0;


        if (category == 0) {

            currentCategory = category1;
        }
        else if(category == 1){
            currentCategory = category2;
        }
        else if(category == 2){
            currentCategory = category3;
        }
        else if (category == 3){
            currentCategory = category4;
        }

        System.out.println(currentCategory.size());
        while (count < currentCategory.size()) {

                if (Integer.valueOf(this.currentCategory.get(count)[1]) != difficulty) {
                    count++;
                    continue;

                } else {
                    currentQuestion = currentCategory.get(count);
                    currentCategory.remove(count);
                    return currentQuestion;
                }


            }


        setCategoryQuestions(category);

        currentQuestion = getQuestionFromCategory(category, difficulty);
        return currentQuestion;


        }






private void setCategoryQuestions(int category){
        try {
            File file = new File("src/Version2/Questions.txt");
            Scanner fileIn = new Scanner(file);
            switch (category) {
                case 0: while(fileIn.hasNextLine() != false){
                    String[] questionParts = fileIn.nextLine().split(",");
                    if(questionParts[0].equals("0"))
                    category1.add(questionParts);}
                    break;

                case 1:while(fileIn.hasNextLine() != false){
                    String[] questionParts = fileIn.nextLine().split(",");
                    if(questionParts[0].equals("1"))
                    category2.add(questionParts);}
                    break;
                case 2:while(fileIn.hasNextLine() != false){
                    String[] questionParts = fileIn.nextLine().split(",");
                    if(questionParts[0].equals( "2"))
                    category3.add(questionParts);}
                    break;
                case 3:while(fileIn.hasNextLine() != false){
                    String[] questionParts = fileIn.nextLine().split(",");
                    if(questionParts[0].equals( "3"))
                    category4.add(questionParts);}
                    break;
                default: throw new java.lang.Error("Something has gone wrong");

            }
            fileIn.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to find stupid file");
        }
        catch (IOException ex){
            System.out.println("error reading file");
        }
}

    public void setAllCategoryQuestions(){
        try {
            //String fileName = "src/Version2/Questions.txt";
            //FileReader reader = new FileReader(fileName);
            File file = new File("src/Version2/Questions.txt");
            //Scanner fileIn = new Scanner(new File("Questions.txt"));
            Scanner fileIn = new Scanner(file);
            //String[] questionParts;// = fileIn.nextLine().split(",");
/*
            category1 = new ArrayList<String[]>();
            category2 = new ArrayList<String[]>();
            category3 = new ArrayList<String[]>();
            category4 = new ArrayList<String[]>();
*/
            while(fileIn.hasNextLine() != false){
                String[] questionParts = fileIn.nextLine().split(",");
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
            Collections.shuffle(category1);
            Collections.shuffle(category2);
            Collections.shuffle(category3);
            Collections.shuffle(category4);

            //category2.add(questionparts);
            System.out.println(category1.get(0)[2]);
            System.out.println(category1.get(1)[2]);
            System.out.println(category2.get(2)[2]);
            System.out.println(category3.get(2)[2]);
            System.out.println(category1.size());
            System.out.println(category4.size());
            //FileReader r = new FileReader("src/Version2/Questions.txt");
            fileIn.close();

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


}
