package GeneticAlgorithm;

// Class for common functions (Read file, calculate distance etc.)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author halil
 */

public class Helper {

    public static List<City> readFile(String fileName) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(fileName));

        int nbrLine = 0;
        int solutionNumber = 0;
        List<City> cityList = new ArrayList<>();
        while (reader.hasNext()) {
            String nextLine = reader.nextLine(); // Get Next Line

            if (nbrLine < 3) {
                nbrLine++;
                continue;
            } // Skip First three Row
            if (nextLine.equals("EOF"))
                break;
            else {
                String[] coordinates = nextLine.replace("\n", "").split(" ");
                int number = Integer.parseInt(coordinates[0]);
                float xCoord = Float.parseFloat(coordinates[1]); // Get X Coordinate
                float yCoord = Float.parseFloat(coordinates[2]); // Get Y Coordinate

                // Create the city based on the information read from the file.
                cityList.add(new City(number, xCoord, yCoord)); // Add city

                // Split Line
            }
        }

        return cityList;
    }

    public static float euclideanDistance(City cityOne, City cityTwo) {
        // Calculate Euclidean Distance
        return (float) Math.sqrt(Math.pow(cityOne.getX_coord() - cityTwo.getX_coord(), 2) + Math.pow(cityOne.getY_coord() - cityTwo.getY_coord(), 2)); // Return objective
    }

    public static void swapCities(City city1, City city2) {
        City temp;
        temp = city1;
        city1 = city2;
        city2 = temp;
    }
}
