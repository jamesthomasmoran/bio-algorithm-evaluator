# Bio Inspired Computing CW1
## General
The git repo includes the intellij workspace config. You should be able to run a Scenario Runner with no config updates within intellij.

In the runner package, there are 4 Scenario runner classes that need to be run:
- GAScenario1Runner (James) - 2nd shortest run time
- GAScenario2Runner (Paul) - longest run time
- PSOScenario1Runner (Lewis) - shortest run time
- PSOScenario2Runner (Paul) - 2nd longest run time

When a Runner class Run is completed a number of folders will be created in a top level directory <b>output</b>. Send your output folder file to Lewis when your runs have finished.

## Package Descriptions

### config
contains config files (not used)

### dependency
contains the 2 algorithm dependency jars

## java/algorithm
Contains code that directly invokes the GA and PSO algorithm. 

## java/file
Contains all code required for creating and writing to files

## java/helper
Contains all code to determine fitness and compare fitness

## java/runner
Contains classes to run that will undertake the test for each scenario

## java/wrapper
Contains Wrapper Objects for parameters
 