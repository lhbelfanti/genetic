package com.genetic.algorithm;

import java.util.Arrays;

/**
 * This program defines a Genetic Algorithm to reach the TARGET_CHROMOSOME {1,1,0,1,0,0,1,1,1,0}
 * starting off randomly generated populations.
 *
 * @author Lucas Belfanti
 */
public class Main {

    public static void main(String[] args) {

        int generationNumber = 0;

        //The first population is created
        Population population = new Population(GeneticAlgorithm.POPULATION_SIZE).initializePopulation();

        printGenerationNumber(generationNumber, population);
        printPopulation(population);

        //The Genetic Algorithm is created
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();

        //While the fitness isn't the searched fitness (10) it creates a new generation by
        //evolving the population created
        while (population.getChromosomes()[0].getFitness() < GeneticAlgorithm.TARGET_CHROMOSOME.length) {
            generationNumber++;
            population = geneticAlgorithm.evolve(population);
            population.sortChromosomeByFitness();
            printGenerationNumber(generationNumber, population);
            printPopulation(population);
        }
    }

    private static void printPopulation(Population population) {
        System.out.println("Target Chromosome: " + Arrays.toString(GeneticAlgorithm.TARGET_CHROMOSOME));
        System.out.println("------------------------------------------------------------");
        for (int x = 0; x < population.getChromosomes().length; x++) {
            System.out.println("Chromosome # " + x + " : " + Arrays.toString(population.getChromosomes()[x].getGenes()) +
                    " | Fitness: " + population.getChromosomes()[x].getFitness());
        }
    }

    private static void printGenerationNumber(int generationNumber, Population population) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Generation # " + generationNumber + " | Fittest chromosome fitness: " +
                population.getChromosomes()[0].getFitness());
    }
}
