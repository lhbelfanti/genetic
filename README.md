<div align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="media/genetic-dark.png">
    <source media="(prefers-color-scheme: light)" srcset="media/genetic-light.png">
    <img alt="Genetic - Genetic algorithm implementation written in Java." src="media/genetic-dark.png">
  </picture>

  <br />

  ![GitHub repo size](https://img.shields.io/github/repo-size/lhbelfanti/genetic?style=for-the-badge)
  ![License](https://img.shields.io/github/license/lhbelfanti/genetic?style=for-the-badge)
</div>

# Genetic Algorithm

This is an implmentation of my first generic algorithm.

Starting off a randomly generated population it will try to reach the target chromosome `{1,1,0,1,0,0,1,1,1,0}` in the least amount of generations.
Each population has 8 chromosomes and each chromosome has 10 genes (because of the genes of the target chromosome).

The target chromosome and the population size can be modified on the GeneticAlgorithm class.