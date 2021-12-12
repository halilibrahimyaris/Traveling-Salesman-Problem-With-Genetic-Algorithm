/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author halil
 */
public class GA {
    public static void main(String[] args) throws FileNotFoundException {
        int startPoint = 0;
        Population currentPopulation = new Population(100);
        currentPopulation.createPopulation(startPoint); // Generate the initial population
        for (int i = 0; i < 5000; i++) {

            for (int j = 0; j < 200; j++) {
                currentPopulation.crossover();
            }
            if(i%100==0){
                currentPopulation.bestSolution.printVisitingOrder();
                System.out.println(i + " . Generation " + "Best Path Value "+ currentPopulation.GetBestPath());
            }



        }
    }

}
