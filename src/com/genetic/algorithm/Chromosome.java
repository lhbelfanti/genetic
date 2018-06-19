package com.genetic.algorithm;

import java.util.Arrays;

/**
 * This class represents a solution for the genetic algorithm.
 * It has a set of properties (genes) which can be mutated and altered.
 * It also has a fitness property which indicates how 'fit' each potential
 * solution is.
 */
public class Chromosome implements Comparable<Chromosome>{

    private boolean hasFitnessChanged = true;
    private int fitness = 0;
    private int[] genes;

    /**
     * Constructor. Defines the quantity of genes (properties).
     *
     * @param length
     */
    public Chromosome(int length) {
        this.genes = new int[length];
    }

    /**
     * Initializes randomly the genes of the chromosome.
     *
     * @return Chromosome
     */
    public Chromosome initializeChromosome() {
        for (int x = 0; x < genes.length; x++) {
            if (Math.random() > 0.5)
                genes[x] = 1;
            else
                genes[x] = 0;
        }

        return this;
    }

    /**
     * Genes getter.
     *
     * @return int[]
     */
    public int[] getGenes() {
        hasFitnessChanged = true;
        return genes;
    }

    /**
     * Fitness getter.
     *
     * @return int
     */
    public int getFitness() {
        if (hasFitnessChanged) {
            fitness = recalculateFitness();
            hasFitnessChanged = false;
        }
        return fitness;
    }

    /**
     * Recalculates the fitness after it has changed.
     *
     * @return int
     */
    public int recalculateFitness() {
        int chromosomeFitness = 0;
        for (int x = 0; x < genes.length; x++) {
            if (genes[x] == GeneticAlgorithm.TARGET_CHROMOSOME[x])
                chromosomeFitness++;
        }

        return chromosomeFitness;
    }

    @Override
    public String toString() {
        return Arrays.toString(genes);
    }

    @Override
    public int compareTo(Chromosome chromosome) {
        if (this.getFitness() > chromosome.getFitness())
            return -1;
        else if (this.getFitness() < chromosome.getFitness())
            return 1;
        return 0;
    }
}
