package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> wallArea = new ArrayList<Double>();
        double ceilingArea;
        double windowArea;
        double doorArea;
        int coats = 0;
        double costPerLitre = 0;

        System.out.println("The Paint Saver");

        while (true) {
            System.out.println("Select Details");
            System.out.println("1. Enter the wall dimensions");
            System.out.println("2. Enter the ceiling dimensions");
            System.out.println("3. Enter the window dimensions");
            System.out.println("4. Enter the door dimensions");
            System.out.println("5. Enter amount of coats");
            System.out.println("6. Enter Cost per litre");
            System.out.println("7. Review");
            System.out.println("8. Calculate");
            int choice = scanner.nextInt();

            switch (choice) {

            }



        }


        System.out.println("how many walls are you painting?: ");
        String wallAmount = scanner.nextLine();
        System.out.println(wallAmount + " walls");

        System.out.println("Wall surface shape: ");
        String surfaceShape = scanner.nextLine();
        System.out.println("Shape of wall: " + surfaceShape );






        }
    }
