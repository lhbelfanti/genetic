package com.genetic.algorithm;

/**
 * This class contains the necessaries methods to create a Genetic
 * Algorithm. It has the methods to evolve, mutate and crossover
 * chromosomes and populations.
 */
public class GeneticAlgorithm {

    //The sought solution
    public static final int[] TARGET_CHROMOSOME = {1,1,0,1,0,0,1,1,1,0};

    //Population size
    public static final int POPULATION_SIZE = 8;

    //Number of chromosomes that won't be modified
    public static final int NUMB_OF_ELITE_CHROMOSOMES = 1;

    //Number of chromosome that will be crossover
    public static final int TOURNAMENT_SELECTION_SIZE = 4;

    //Mutation rate for the chromosomes
    private static final double MUTATION_RATE = 0.25;

    /**
     * Evolves a population and returns a new generation. It mutates
     * a crossover population.
     *
     * @param population
     * @return Population
     */
    public Population evolve(Population population) {
        return mutatePopulation(crossoverPopulation(population));
    }

    /**
     * Mutates a population by mutating it chromosomes.
     * There is a number of elite chromosomes (NUMB_OF_ELITE_CHROMOSOMES) that won't be
     * modified on the mutation.
     *
     * @param population
     * @return Population
     */
    private Population mutatePopulation(Population population) {
        Population mutatedPopulation = new Population(population.getChromosomes().length);
        for (int x = 0; x < NUMB_OF_ELITE_CHROMOSOMES; x++) {
            mutatedPopulation.getChromosomes()[x] = population.getChromosomes()[x];
        }

        for (int x = NUMB_OF_ELITE_CHROMOSOMES; x < population.getChromosomes().length; x++) {
            mutatedPopulation.getChromosomes()[x] = mutateChromosome(population.getChromosomes()[x]);
        }

        return mutatedPopulation;
    }

    /**
     * Randomly mutates the genes of a chromosome.
     *
     * @param chromosome
     * @return Chromosome
     */
    private Chromosome mutateChromosome(Chromosome chromosome) {
        Chromosome mutateChromosome = new Chromosome(TARGET_CHROMOSOME.length);
        for (int x = 0; x < chromosome.getGenes().length; x++) {
            if (Math.random() < MUTATION_RATE)
                if (Math.random() < 0.5)
                    mutateChromosome.getGenes()[x] = 1;
                else
                    mutateChromosome.getGenes()[x] = 0;
            else
                mutateChromosome.getGenes()[x] = chromosome.getGenes()[x];
        }
        return mutateChromosome;
    }

    /**
     * Crossovers the chromosomes of two populations.
     * There is a number of elite chromosomes (NUMB_OF_ELITE_CHROMOSOMES) that won't be
     * modified on the crossover.
     *
     * @param population
     * @return Population
     */
    private Population crossoverPopulation(Population population) {
        Population crossoverPopulation = new Population(population.getChromosomes().length);
        for (int x = 0; x < NUMB_OF_ELITE_CHROMOSOMES; x++) {
            crossoverPopulation.getChromosomes()[x] = population.getChromosomes()[x];
        }

        for (int x = NUMB_OF_ELITE_CHROMOSOMES; x < population.getChromosomes().length; x++) {
            Chromosome chromosome1 = selectTournamentPopulation(population).getChromosomes()[0];
            Chromosome chromosome2 = selectTournamentPopulation(population).getChromosomes()[0];
            crossoverPopulation.getChromosomes()[x] = crossoverChromosome(chromosome1, chromosome2);
        }

        return crossoverPopulation;
    }

    /**
     * Creates a population of random chromosomes from a specified population.
     * The number of chromosomes it will contains is defined by TOURNAMENT_SELECTION_SIZE
     * constant. The population is ordered by the fitness the chromosomes, thus the first
     * chromosome can be used on the population crossover.
     *
     * @param population
     * @return Population
     */
    private Population selectTournamentPopulation(Population population) {
        Population tournamentPopulation = new Population(TOURNAMENT_SELECTION_SIZE);
        int randomChromosome;
        for (int x = 0; x < TOURNAMENT_SELECTION_SIZE; x++) {
            randomChromosome = (int) (Math.random() * population.getChromosomes().length);
            tournamentPopulation.getChromosomes()[x] = population.getChromosomes()[randomChromosome];
        }
        tournamentPopulation.sortChromosomeByFitness();
        return tournamentPopulation;
    }

    /**
     * Randomly crossovers the genes of two chromosomes.
     *
     * @param chromosome1
     * @param chromosome2
     * @return Chromosome
     */
    private Chromosome crossoverChromosome(Chromosome chromosome1, Chromosome chromosome2) {
        Chromosome crossoverChromosome = new Chromosome(TARGET_CHROMOSOME.length);
        for (int x = 0; x < chromosome1.getGenes().length; x++) {
            if (Math.random() < 0.5)
                crossoverChromosome.getGenes()[x] = chromosome1.getGenes()[x];
            else
                crossoverChromosome.getGenes()[x] = chromosome2.getGenes()[x];
        }
        return crossoverChromosome;
    }
}
