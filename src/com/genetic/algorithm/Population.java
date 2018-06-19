package com.genetic.algorithm;

import java.util.Arrays;

/**
 * This class represents a set of candidate solutions for the genetic
 * algorithm.
 *
 * @author Lucas Belfanti
 */
public class Population {

    /**
     * The set of candidate solutions.
     */
    private Chromosome[] chromosomes;

    /**
     * Constructor. Defines the quantity of chromosomes (candidate solutions).
     *
     * @param length
     */
    public Population(int length) {
        this.chromosomes = new Chromosome[length];
    }

    /**
     * Initializes the quantity of chromosomes defined and sort them.
     *
     * @return Population
     */
    public Population initializePopulation() {
        for (int x = 0; x < chromosomes.length; x++) {
            chromosomes[x] = new Chromosome(GeneticAlgorithm.TARGET_CHROMOSOME.length).initializeChromosome();
        }

        sortChromosomeByFitness();
        return this;
    }

    /**
     * Chromosomes getter.
     *
     * @return Chromosome[]
     */
    public Chromosome[] getChromosomes() {
        return chromosomes;
    }

    /**
     * Sort the array with the initialized chromosomes.
     */
    public void sortChromosomeByFitness() {
        Arrays.sort(chromosomes);
    }
}
