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
    int score = 0;
    int count_correct = 0;
    Authorize.auth(args);
    Scanner scanner = new Scanner(System.in);
    try {
      File file = new File("Questions.csv");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);

      String line;
      while((line = br.readLine()) != null) {
        String[] row = line.split(";");
        System.out.println(Colors.CYAN + "Вопрос №" + row[0] + Colors.RESET);
        System.out.println(Colors.YELLOW + "a)" + Colors.RESET + row[1] + Colors.YELLOW + " b)" + Colors.RESET + row[2] + Colors.YELLOW + " c)" + Colors.RESET + row[3]);
        System.out.print("Выберите вариант ответа(a, b, c): ");
        String option = scanner.nextLine();

        if (option.equals("a")) {
          if (row[1].equals(row[4])) {
            System.out.println(Colors.GREEN + "Ответ верный! Вы заработали 5 баллов!" + Colors.RESET);
            score += 5;
            count_correct += 1;
          } else {
            System.out.println(Colors.RED + "Ответ неверный! Вы не заработали баллы!" + Colors.RESET);
          }
        }
        else if (option.equals("b")) {
          if (row[2].equals(row[4])) {
            System.out.println(Colors.GREEN + "Ответ верный! Вы заработали 5 баллов!" + Colors.RESET);
            score += 5;
            count_correct += 1;
          } else {
            System.out.println(Colors.RED + "Ответ неверный! Вы не заработали баллы!" + Colors.RESET);
          }
        } 
        else if (option.equals("c")) {
          if (row[3].equals(row[4])) {
            System.out.println(Colors.GREEN + "Ответ верный! Вы заработали 5 баллов!" + Colors.RESET);
            score += 5;
            count_correct += 1;
          } else {
            System.out.println(Colors.RED + "Ответ неверный! Вы не заработали баллы!" + Colors.RESET);
          } 
      } else {
        System.out.println(Colors.YELLOW + "Такого варианта ответа не существует!" + Colors.RESET);
      }
    }
    
    br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(Colors.YELLOW + "Поздравляю! Вы прошли тест!" + Colors.RESET);
    System.out.println(Colors.PURPLE + "Количество набранных баллов: " + Colors.RESET + score);
    System.out.println(Colors.PURPLE + "Количество правильных ответов: " + Colors.RESET + count_correct);
  }
}