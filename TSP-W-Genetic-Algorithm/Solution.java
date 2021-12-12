package GeneticAlgorithm;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author halil
 */
public class Solution {

    // Objective Value of Solution
    public List<City> visitingOrder; // Store Visit Order (Each item must be City)
    public float fitnessValue;
    List<City> cities = Helper.readFile("src/GeneticAlgorithm/Cities Coordinates.tsp");

    // Default Constructor
    public Solution(int startPoint) throws FileNotFoundException {
        visitingOrder = new ArrayList<>();
        createRndVisitOrder(cities, startPoint);
        calculateObjective();
    }

    public void createRndVisitOrder(List<City> cities, int startPoint) {
        for (int i = 0; i < cities.size(); i++) {
            if (i == startPoint)
                continue;
            else
                visitingOrder.add(cities.get(i));
        }
        Collections.shuffle(visitingOrder); // Randomly shuffle the location of the cities.
        visitingOrder.add(0, cities.get(startPoint)); // Add start city to visiting order
    }


    public void printVisitingOrder() {
        for (City city : visitingOrder) {
            System.out.print(city.getNumber() + " ");

        }
        System.out.println();
    }

    public void calculateObjective() {
        float sum = 0;
        int i;
        for (i = 0; i < visitingOrder.size() - 1; i++) {
            sum += Helper.euclideanDistance(visitingOrder.get(i), visitingOrder.get(i + 1));
        }
        sum += Helper.euclideanDistance(visitingOrder.get(0), visitingOrder.get(i));
        fitnessValue = sum;
    }

    public float getObj() {
        return fitnessValue;
    }

}
