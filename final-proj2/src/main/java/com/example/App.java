package com.example;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        boolean check = true;
        System.out.println("\033[H\033[2J");
        System.out.flush();

        while (check) {

            System.out.println("Welcome!");
            System.out.println("Choose an option by entering its number.");
            System.out.println("1. Sign in Staff");
            System.out.println("2. Sign in Admin");
            System.out.println("3. Exit");

            try {
                int choose = scn.nextInt();

                switch (choose) {
                    case 1:
                        Signin_Staff();
                        break;

                    case 2:
                        Signin_Admin();
                        break;

                    case 3:
                        check = false;
                        System.out.println("Good Bye :)");
                        break;

                    default:
                        System.out.println("The number is not allowed!!!!!"+"\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("The number is not allowed!!!!!"+"\n");
            }
        }
    }

    public static void Signin_Admin() {
        Scanner inputString = new Scanner(System.in);
        Menue menu = new Menue();

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println("Enter your Name:");
        String name = inputString.nextLine();
        System.out.println("Enter your Password:");
        String password = inputString.nextLine();
        Admin human = Sign.signInAdmin(name, password);

        if(human !=null) {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println("Welcome Admin." + human.getName());
            menu.startHispital(human);
        }else
            System.out.println("You are not a Admin of this clinic!!!!!"+"\n");

    }

    public static void Signin_Staff() {
        Scanner inputString = new Scanner(System.in);
        Menue menu = new Menue();
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter your Name:");
        String name = inputString.nextLine();
        System.out.println("Enter your Password:");
        String password = inputString.nextLine();
        Person human = Sign.signInStaff(name, password);

        System.out.println("\033[H\033[2J");
        System.out.flush();

        if (human instanceof Doctor) {
            human = (Doctor) human;
            System.out.println("Welcome Dr." + human.getName());
            menu.startHispital(human);

        } else if (human instanceof Nurse) {
            human = (Nurse) human;
            System.out.println("Welcome Nurse " + human.getName());
            menu.startHispital(human);
        }else {
            System.out.println("You are not a member of this clinic!!!!!"+"\n");
        }

    }
}
