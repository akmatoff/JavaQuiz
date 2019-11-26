import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    String[] question_list;
    String[] answer1_list;
    String[] answer2_list;
    String[] answer3_list;
    String[] correct_answer_list;

    int question_num;
    int correct_answers_num;

    String mark;
    String[] score;
    String[] result;

    BufferedReader csvReader = new BufferedReader(new fileReader(Questions.csv));
    while((row = csvReader.readLine()) != null) {
      String[] data = row.split(";");
      String question = row[0];
      String answer1 = row[1];
      String answer2 = row[2];
      String answer3 = row[3];
      String correct_answer = row[4];
      
      
      
    }
    csvReader.close();

  }
}