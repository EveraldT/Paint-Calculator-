package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> wallAreaList = new ArrayList<Double>();
        double wallArea = 0;
        double ceilingArea = 0;
        double windowArea = 0;
        double doorArea = 0;
        int coats = 0;
        double costPerLitre = 0;
        int CanSize;
        double calucatedCoverage = 0;
        double excludedCoverage = 0;
        ArrayList<Double> excludedCoverageList = new ArrayList<Double>();


        System.out.println("The Paint Saver");

        while (true) {
            System.out.println("Select Details");
            System.out.println("1. Enter the wall dimensions");
            System.out.println("2. Enter the ceiling dimensions");
            System.out.println("3. Enter the window dimensions");
            System.out.println("4. Enter the door dimensions");
            System.out.println("5. Enter amount of coats");
            System.out.println("7. Enter Cost per litre");
            System.out.println("8. Enter dimensions of any areas you want to exclude and not cover");
            System.out.println("9. Review");
            System.out.println("10. Calculate");
            int choice = scanner.nextInt();
            //change door and windows as part of one switch case for total excluded coverage, ask user how many coverage objects,
            // then ask for dimensions of each object, then add each object to an arraylist of total excluded coverage. take value and put in variable
            // for paintable surface calculation

            switch (choice) {
                case 1: //enter wall dimensions
                    System.out.println("enter the height of the wall: ");
                    double wallHeight = scanner.nextDouble();
                    System.out.println("enter the width of the wall: ");
                    double wallWidth = scanner.nextDouble();
                    double wallSurfaceArea = wallHeight * wallWidth;
                    System.out.println(wallSurfaceArea);
                    wallArea = wallHeight * wallWidth;
                    System.out.println("wall area of " + wallSurfaceArea + " added");
                    break;
            }

            switch (choice) {
                case 2: //enter ceiling dimensions
                    System.out.println("enter the height of the ceiling: ");
                    double ceilingHeight = scanner.nextDouble();
                    System.out.println("enter the width of the wall: ");
                    double ceilingWidth = scanner.nextDouble();
                    ceilingArea = ceilingHeight * ceilingWidth;
                    System.out.println(ceilingArea);
                    System.out.println("ceiling area of " + ceilingArea + " added");
                    break;
            }

            switch (choice) {
                case 3: //enter window dimensions
                    System.out.println("enter the height of the window: ");
                    double windowHeight = scanner.nextDouble();
                    System.out.println("enter the width of the window: ");
                    double windowWidth = scanner.nextDouble();
                    windowArea = windowHeight * windowWidth;
                    System.out.println(windowArea);
                    System.out.println("window area of " + windowArea + " added");
                    break;
            }

            switch (choice) {
                case 4: //enter door dimensions
                    System.out.println("enter the height of the door: ");
                    double doorHeight = scanner.nextDouble();
                    System.out.println("enter the width of the door: ");
                    double doorWidth = scanner.nextDouble();
                    doorArea = doorHeight * doorWidth;
                    System.out.println(doorArea);
                    System.out.println("door area of " + doorArea + " added");
                    break;
            }

            switch (choice) {
                case 5: //enter amount of coats
                    System.out.println("enter the amount of coats for the wall: ");
                    coats = scanner.nextInt();
                    System.out.println("coat amount of " + coats + " added");
                    break;
            }

            switch (choice) {
                case 6: //enter cost per litre
                    System.out.println("enter cost per litre: ");
                    costPerLitre = scanner.nextInt();
                    System.out.println("cost per litre of " + costPerLitre + " added");
                    break;
            }

            switch (choice) {
                case 7: //view
                    System.out.println("Wall area: " + wallArea );
                    System.out.println("Ceiling area: " + ceilingArea );
                    System.out.println("Window area: " + windowArea );
                    System.out.println("Door area: " + doorArea );
                    System.out.println("Coats: " + coats );
                    System.out.println("Cost per litre: " + costPerLitre);
                    System.out.println("Excluded Coverage: " + excludedCoverage);

                    break;
            }

            switch (choice) {
                case 8: //coverage exclusion
                    //ask for dimensions of the coverage user wants excluded
                    //have it so multiple shapes of coverage can be added (arrray list)


                    break;
            }

            switch (choice) {
                case 9: //calculate coverage
                    System.out.println(calculateCoverage(wallArea, ceilingArea, windowArea, doorArea, coats));

                    break;
            }



        }


        }

    public static double calculateCoverage(double wallArea, double ceilingArea, double windowArea, double doorArea, int coats) {
        double nonPaintableArea = windowArea + doorArea;
        double paintableArea = (wallArea + ceilingArea - nonPaintableArea) * coats;

        if (paintableArea < 0) {
            System.out.println("Warning: Non-paintable area exceeds paintable area. Check your inputs!");
            paintableArea = 0; // Avoid negative values
        }

        return paintableArea;
    }


}
