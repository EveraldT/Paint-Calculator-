package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double wallArea = 0;
        int coats = 1;
        double costPerLitre = 0;
        double totalCoverage;
        double totalExcludedArea = 0;
        double coveragePerLiter = 0;
        ArrayList<Double> excludedCoverageList = new ArrayList<Double>();

        System.out.println("The Paint Calculator");
        System.out.println("Enter corresponding numbers for the questions display");

        while (true) {
            System.out.println("Select Details");
            System.out.println("1. Enter the wall dimensions(metres)");
            System.out.println("2. Enter amount of coats");
            System.out.println("3. Enter Cost Per Litre");
            System.out.println("4. Enter Coverage Per Litre");
            System.out.println("5. Enter dimensions of any areas you want to exclude and not cover");
            System.out.println("6. View Details");
            System.out.println("7. Calculate");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Enter wall dimensions
                    System.out.println("Select the shape of the wall:");
                    System.out.println("1. Rectangle");
                    System.out.println("2. Circle");
                    System.out.println("3. Triangle");
                    System.out.println("4. Custom Shape with Known Area");

                    int shapeChoice = scanner.nextInt();
                    wallArea = 0;

                    switch (shapeChoice) {
                        case 1: // Rectangle
                            System.out.println("Enter the height of the wall: ");
                            double wallHeight = 0; // Declare the variable
                            while (!scanner.hasNextDouble() || (wallHeight = scanner.nextDouble()) <= 0) {
                                System.out.println("Invalid input. Please enter a positive number for the height.");
                                scanner.next();
                            }
                            System.out.println("Enter the width of the wall: ");
                            double wallWidth = 0; // Declare the variable
                            while (!scanner.hasNextDouble() || (wallWidth = scanner.nextDouble()) <= 0) {
                                System.out.println("Invalid input. Please enter a positive number for the width.");
                                scanner.next();
                            }
                            wallArea = calculateRectangleArea(wallHeight, wallWidth);
                            break;

                        case 2: // Circle
                            System.out.println("Enter the diameter of the wall: ");
                            double wallDiameter = 0;
                            while (!scanner.hasNextDouble() || (wallDiameter = scanner.nextDouble()) <= 0) {
                                System.out.println("Invalid input. Please enter a positive number for the diameter.");
                                scanner.next();
                            }
                            double wallRadius = wallDiameter / 2;
                            wallArea = calculateCircleArea(wallRadius);
                            break;

                        case 3: // Triangle
                            System.out.println("Enter the base of the wall: ");
                            double wallBase = 0;
                            while (!scanner.hasNextDouble() || (wallBase = scanner.nextDouble()) <= 0) {
                                System.out.println("Invalid input. Please enter a positive number for the base.");
                                scanner.next();
                            }
                            System.out.println("Enter the height of the wall: ");
                            double wallHeightTriangle = 0;
                            while (!scanner.hasNextDouble() || (wallHeightTriangle = scanner.nextDouble()) <= 0) {
                                System.out.println("Invalid input. Please enter a positive number for the height.");
                                scanner.next();
                            }
                            wallArea = calculateTriangleArea(wallBase, wallHeightTriangle);
                            break;

                        case 4: // Known area
                            System.out.println("Enter the wall area directly:");
                            while (!scanner.hasNextDouble() || (wallArea = scanner.nextDouble()) <= 0) {
                                System.out.println("Invalid input. Please enter a positive number for the wall area.");
                                scanner.next();
                            }
                            break;

                        default:
                            System.out.println("Invalid selection. Wall area set to 0.");
                    }

                    if (wallArea > 0) {
                        System.out.println("Wall area of " + wallArea + " square meters added.");
                    } else {
                        System.out.println("Wall area not set. Please try again.");
                    }
                    break;

            }

            switch (choice) {
                case 2: //enter amount of coats
                    System.out.println("Enter the amount of coats for the wall: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid integer for the amount of coats.");
                        scanner.next(); // Clear the invalid input
                    }
                    coats = scanner.nextInt();
                    while (coats <= 0) {
                        System.out.println("Must be more than zero.");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a valid integer for the amount of coats.");
                            scanner.next(); // Clear the invalid input
                        }
                        coats = scanner.nextInt();
                    }
                    System.out.println("Coat amount of " + coats + " added");
                    break;
            }

                switch (choice) {
                    case 3: //enter cost per litre
                        System.out.println("Enter the cost per litre: £");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a valid number for the cost per litre.");
                            scanner.next(); // Clear the invalid input
                        }
                        costPerLitre = scanner.nextDouble();
                        // Check if the cost is greater than zero
                        while (costPerLitre <= 0) {
                            System.out.println("Cost per litre cannot be zero or negative. Please enter a valid positive value.");
                            while (!scanner.hasNextDouble()) {
                                System.out.println("Invalid input. Please enter a valid number for the cost per litre.");
                                scanner.next(); // Clear the invalid input
                            }
                            costPerLitre = scanner.nextDouble();
                        }
                        System.out.println("Cost per litre of £" + String.format("%.2f", costPerLitre) + " added");
                        break;

                }

            switch (choice) {
                case 4:
                    System.out.println("Enter how many square meters a liter of paint covers: ");
                    while (!scanner.hasNextDouble() || (coveragePerLiter = scanner.nextDouble()) <= 0) {
                        System.out.println("Invalid input. Please enter a positive number for coverage per liter.");
                        scanner.next();
                    }
                    System.out.println("Paint coverage of " + coveragePerLiter + " added");
                    break;

            }

            switch (choice) {
                case 5: // Coverage exclusion
                    System.out.println("Add areas you want to exclude (non-paintable areas):");
                    while (true) {
                        double excludedArea = calculateShapeArea(scanner);
                        excludedCoverageList.add(excludedArea);
                        System.out.println("Excluded area of " + excludedArea + " added.");

                        System.out.println("Do you want to add another excluded area? (yes/no):");
                        String response = scanner.next().toLowerCase();
                        if (!response.equals("yes")) {
                            break;
                        }
                    }
                    totalExcludedArea = 0;
                    for (double area : excludedCoverageList) {
                        totalExcludedArea += area;
                    }
                    System.out.println("Total excluded coverage area: " + totalExcludedArea);
                    break;

            }



            switch (choice) {
                case 6: //view
                    System.out.println("Wall area: " + wallArea + "square metres" );
                    System.out.println("Coats: " + coats );
                    System.out.println("Cost per litre: " + "£" + costPerLitre);
                    System.out.println("Coverage per litre: " + coveragePerLiter);
                    System.out.println("Excluded Coverage: " + totalExcludedArea + "square metres");
                    break;
            }

            switch (choice) {
                case 7: // Calculate coverage

                    if (wallArea == 0) {
                        System.out.println("You haven't entered wall dimensions yet. Please enter the dimensions first.");
                        continue;
                    }
                    if (coats == 0) {
                        System.out.println("You haven't entered the number of coats yet. Please enter the coats first.");
                        continue;
                    }
                    if (costPerLitre == 0) {
                        System.out.println("You haven't entered the cost per litre yet. Please enter the cost per litre.");
                        continue;
                    }

                    if (coveragePerLiter == 0) {
                        System.out.println("You haven't entered the coverage per litre yet. Please enter the cost per litre.");
                        continue;
                    }
                        totalCoverage = calculateCoverage(wallArea, totalExcludedArea, coats);
                        double totalLitersRequired = totalCoverage / coveragePerLiter;

                    // Display the coverage without waste
                        System.out.println("Total liters of paint required without waste: " + totalLitersRequired + "L");
                        // Ask the user if they want to account for 10% waste
                        System.out.println("Would you like to account for 10% waste? (yes/no): ");
                        String wasteChoice = scanner.next();
                        // If the user chooses to account for waste
                        if (wasteChoice.equalsIgnoreCase("yes")) {
                            totalLitersRequired *= 1.10; // Add 10% extra for waste
                            System.out.println("Total coverage with 10% waste: " + String.format("%.2f", totalLitersRequired) + "L");
                        } else {
                            System.out.println("Total coverage without waste: " + String.format("%.2f", totalLitersRequired) + "L");
                        }

                        // Calculate the total cost
                        double totalCost = totalLitersRequired * costPerLitre;
                        System.out.println("Total cost for paint coverage: £" + String.format("%.2f", totalCost));

                        break;

            }

            switch (choice) {
                case 8:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
            }

        }
        }

    public static double calculateCoverage(double wallArea, double totalExcludedArea, int coats) {
        double paintableArea = (wallArea - totalExcludedArea) * coats;

        if (paintableArea < 0) {
            System.out.println("Warning: Non-paintable area exceeds paintable area. Check your inputs!");
            paintableArea = 0; // Avoid negative values
        }

        return paintableArea;
    }

    public static double calculateShapeArea(Scanner scanner) {
        System.out.println("Select the shape to calculate area:");
        System.out.println("1. Rectangle");
        System.out.println("2. Circle");
        System.out.println("3. Triangle");
        System.out.println("4. Custom Shape with Known Area");

        int shapeChoice = scanner.nextInt();
        double area = 0;

        switch (shapeChoice) {
            case 1: // Rectangle
                System.out.println("Enter length:");
                double length = scanner.nextDouble();
                System.out.println("Enter width:");
                double width = scanner.nextDouble();
                area = calculateRectangleArea(length, width);
                break;

            case 2: // Circle
                System.out.println("Enter diameter:");
                double diameter = scanner.nextDouble();
                double radius = diameter / 2; // Convert diameter to radius
                area = calculateCircleArea(radius);
                break;

            case 3: // Triangle
                System.out.println("Enter base:");
                double base = scanner.nextDouble();
                System.out.println("Enter height:");
                double height = scanner.nextDouble();
                area = calculateTriangleArea(base, height);
                break;

            case 4: // Known Area
                System.out.println("Enter the area directly:");
                area = scanner.nextDouble();
                break;

            default:
                System.out.println("Invalid shape selection. Area set to 0.");
        }

        System.out.println("Calculated area: " + area + " square units");
        return area;
    }


    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }





}
