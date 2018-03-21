package Version4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuestionDatabase {
    private ArrayList<String[]> category1;
    private ArrayList<String[]> category2;
    private ArrayList<String[]> category3;
    private ArrayList<String[]> category4;
    private String[] currentQuestion;

    public QuestionDatabase() {

        category1 = new ArrayList<>();
        category2 = new ArrayList<>();
        category3 = new ArrayList<>();
        category4 = new ArrayList<>();

    }

    public String[] getQuestionFromCategory(int category, int difficulty) {

        ArrayList<String[]> currentCategory = new ArrayList<>();

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

        while (count < currentCategory.size()) {

                if (Integer.valueOf(currentCategory.get(count)[1]) != difficulty) {
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
            File file = new File("res/Questions.txt");
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
                default: throw new Error("Something has gone wrong");

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

            File file = new File("res/Questions.txt");

            Scanner fileIn = new Scanner(file);

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

            fileIn.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to find stupid file");
        }
        catch (IOException ex){
            System.out.println("error reading file");
        }
    }
}
