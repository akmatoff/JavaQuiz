import java.util.Scanner;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;

public class Authorize {

    private static void authOrReg() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите " + Colors.GREEN_BOLD + "1 " + Colors.RESET + "для авторизации, " + Colors.CYAN_BOLD + "2 " + Colors.RESET + "для регистрации: ");
        int authReg = scanner.nextInt();

        if (authReg == 1) {
            loginForm();
        } else if (authReg == 2) {
            registerForm();
        } else {
            authOrReg();
        }
    }

    private static void registerForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Регистрация ----------");
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.println("Введите пароль еще раз для подтверждения: ");
        String confirm = scanner.nextLine();

        if (confirm.equals(password)) {
            try {
                FileWriter fw = new FileWriter("users.csv", true);
                PrintWriter pw = new PrintWriter(fw);

                pw.append(login);
                pw.append(",");
                pw.append(password);
                pw.append("\n");

                pw.close();

            } catch (Exception e) {
                System.out.print("Syntax error: Baichik\'s brain not found!");
            }

        } else {
            System.out.println(Colors.RED + "Пароли не совпадают! Повторите попытку!" + Colors.RESET);
            registerForm();
        }
        System.out.println(Colors.GREEN + "Добро пожаловать, " + Colors.RESET + Colors.PURPLE + login + "!" + Colors.RESET);
    }

    private static void loginForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Авторизация ----------");
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        try {
            File file = new File("users.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            String[] row = {};
            while ((line = br.readLine()) != null) {
                row = line.split(",");

                if (login.equals(row[0]) && password.equals(row[1])) {
                    System.out.println(Colors.GREEN + "Добро пожаловать, " + Colors.RESET + Colors.PURPLE + login + "!" + Colors.RESET);
                    break;
                }
            }
            if (!login.equals(row[0]) || !password.equals(row[1])) {
                System.out.println(Colors.RED + "Неверный логин или пароль! Повторите попытку!" + Colors.RESET);
                loginForm();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void auth(String[] args) {
        authOrReg();
    }
}