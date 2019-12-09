import java.util.Scanner;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;

class Main {
  public static void main(String[] args) {
    Authorize.auth(args);
    Scanner scanner = new Scanner(System.in);
    try {
      File file = new File("Questions.csv");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);

      String line;
      while((line = br.readLine()) != null) {
        String[] row = line.split(";");
        System.out.println("Вопрос №" + row[0]);
        System.out.println("a)" + row[1] + " b)" + row[2] + " c)" + row[3]);
        System.out.print("Выберите вариант ответа(a, b, c): ");
        String option = scanner.nextLine();

        if (option.equals("a")) {
          if (row[1].equals(row[4])) {
            System.out.println("Ответ верный! Вы заработали 5 баллов!");
          } else {
            System.out.println("Ответ неверный! Вы не заработали баллы!");
          }
        }
        else if (option.equals("b")) {
          if (row[2].equals(row[4])) {
            System.out.println("Ответ верный! Вы заработали 5 баллов!");
          } else {
            System.out.println("Ответ неверный! Вы не заработали баллы!");
        }
        } 
        else if (option.equals("c")) {
          if (row[2].equals(row[4])) {
            System.out.println("Ответ верный! Вы заработали 5 баллов!");
          } else {
            System.out.println("Ответ неверный! Вы не заработали баллы!");
          } 
      } else {
        System.out.println("Такого варианта ответа не существует!");
      }
    }
    
    br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}