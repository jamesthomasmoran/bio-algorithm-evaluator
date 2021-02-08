# Bio Inspired Algorithm Evaluator

## General
Project that evaluates the best algorithm parameters to use for the Genetic Algorithm and Particle Swarm Optimisation Algorithm in tackling the Rastringin Problem. All Results are saved to an output csv file.

The Project contains 4 test Runners which evaluate different scenarios:

- <b>GAScenario1Runner</b> - Evaluates a number of different combinations of population size and number of iterations for the Genetic Algorithm. Each combination has a total 10,000 evaluations per run.
- <b>PSOScenario1Runner</b> - Evaluates a number of different combinations of number of particles and number of iterations for the Particle Swarm Optimisation Algorithm. Each combination has a total 10,000 evaluations per run.
- <b>GAScenario2Runner</b> - Evaluates a population size of 1000 and a number of iterations of 1000 for the Genetic Algorithm. Each Run of the algorithm will have a total 1,000,000 evaluations
- <b>PSOScenario2Runner</b> - Evaluates a number of particles of 1000 and a number of iterations of 1000 for the Particle Swarm Optimisation Algorithm. Each Run of the algorithm will have a total 1,000,000 evaluations

## Technologies
Project is Created with:
- Java version: 8
- Jenetics Library version: 4.2.0
- JSwarm  Library version: 2.08

## Package Descriptions

### dependency
contains the 2 algorithm dependency jars, Jenetics and JSwarm.

### algorithm
Contains code that directly invokes the GA and PSO algorithm. 

### file
Contains all code required for creating and writing to files

### helper
Contains all code to determine fitness and compare fitness

### runner
Contains classes to run that will undertake the test for each scenario

### wrapper
Contains Wrapper Objects for parameters

 
