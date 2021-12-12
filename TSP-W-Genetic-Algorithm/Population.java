/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author halil
 */
public class Population {

    int popSize; // Store the population size
    private Solution solutions[]; // Store the each individual, chromosome in this population
    //List<City> cities = Helper.readFile("src/GeneticAlgorithm/Cities Coordinates.tsp");
    Solution bestSolution = null;
    Solution secondBestSolution = null;

    public Population(int popSize) throws FileNotFoundException {
        this.popSize = popSize;
        this.solutions = new Solution[popSize];
    }

    public void createPopulation(int startPoint) throws FileNotFoundException {
        for (int i = 0; i < this.popSize; i++) {
            solutions[i] = new Solution(startPoint);
        }
    }

    public void printPopulation() {
        for (int i = 0; i < solutions.length; i++) {
            System.out.print("TSP Road Map = ");
            solutions[i].printVisitingOrder();
            System.out.println("");
            System.out.print("Fitness Value = " + solutions[i].fitnessValue);
            System.out.println("");
        }
    }

    public void crossover() throws FileNotFoundException {
        Solution[] crossedSolutions = new Solution[2];
        crossedSolutions[0] = new Solution(2);
        crossedSolutions[1] = new Solution(2);


        GetBestPath();
        for (int i = 0; i < bestSolution.visitingOrder.size(); i++) {
            crossedSolutions[0].visitingOrder.set(i, bestSolution.visitingOrder.get(i));
            crossedSolutions[1].visitingOrder.set(i, secondBestSolution.visitingOrder.get(i));

        }

        int rnd = new Random().nextInt(70) + 1;

        List<City> selectedCites = new ArrayList<>();
        List<City> selectedCites2 = new ArrayList<>();
        selectedCites.add(crossedSolutions[0].visitingOrder.get(rnd + 1));
        selectedCites.add(crossedSolutions[0].visitingOrder.get(rnd + 2));
        selectedCites.add(crossedSolutions[0].visitingOrder.get(rnd + 3));

        selectedCites2.add(crossedSolutions[1].visitingOrder.get(rnd + 1));
        selectedCites2.add(crossedSolutions[1].visitingOrder.get(rnd + 2));
        selectedCites2.add(crossedSolutions[1].visitingOrder.get(rnd + 3));


        for (int i = 1; i < selectedCites2.size(); i++) {
            for (int j = 1; j < crossedSolutions[0].visitingOrder.size(); j++) {
                if (selectedCites2.get(i) == crossedSolutions[0].visitingOrder.get(j)) {
                    crossedSolutions[0].visitingOrder.set(j, crossedSolutions[0].visitingOrder.get(i));
                    crossedSolutions[0].visitingOrder.set(i, selectedCites2.get(i));
                    break;
                }
            }

        }
        for (int i = 1; i < selectedCites.size(); i++) {
            for (int j = 1; j < crossedSolutions[1].visitingOrder.size(); j++) {
                if (selectedCites.get(i) == crossedSolutions[1].visitingOrder.get(j)) {
                    crossedSolutions[1].visitingOrder.set(j, crossedSolutions[1].visitingOrder.get(i));
                    crossedSolutions[1].visitingOrder.set(i, selectedCites.get(i));
                    break;
                }
            }
        }


        mutateSolution(crossedSolutions[1]);
        mutateSolution(crossedSolutions[0]);

        crossedSolutions[0].calculateObjective();
        crossedSolutions[1].calculateObjective();

        survivorSelection(crossedSolutions[0]);
        survivorSelection(crossedSolutions[1]);
    }

    public Solution mutateSolution(Solution sol1) {

        int rnd = new Random().nextInt(70) + 1;

        Collections.reverse(sol1.visitingOrder.subList(rnd + 3, rnd + 15));

        return sol1;
    }

    public void survivorSelection(Solution sol1) {
        int largest = 0;
        for (int i = 1; i < solutions.length; i++) {
            if (solutions[i].fitnessValue > solutions[largest].fitnessValue) {
                largest = i;
            }
        }
        if (solutions[largest].fitnessValue > sol1.fitnessValue) {
            solutions[largest] = sol1;
            solutions[largest].calculateObjective();

        }
    }

    public float GetBestPath() {
        float temp = 20000;
        for (Solution sol : solutions) {
            sol.calculateObjective();
            if (temp > sol.fitnessValue) {
                temp = sol.fitnessValue;
                secondBestSolution = bestSolution;
                bestSolution = sol;
            }
        }
        return temp;
    }

}
