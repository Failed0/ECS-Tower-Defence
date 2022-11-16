# ECS-Building-Defence
This is the first time I extensively coded java, readme.txt if you are interested
# Basic  #

## Part 1 ##
I have implemented the classes Bug,ConcurrentModificationBug,NoneTerminationBug,NullPointerBug following the coursework specification

## Part 2 ##
I have implemented the class building following the coursework specification

## Part 3 ##
I have implemented the class Student,AiStudent,CsStudent,CyberStudent,SeStudent following the courseworkspecification

## Part 4 ##
I have implemented the class Team following the coursework specification

## Part 5 ##
I have implemented the class Battle following the coursework specification

## Part 6 ##
I have implemented the class EcsBuildingDefence following the coursework specification

# Extension #
I have implement the following extension.

I have given following Special Abilities to following Bugs

1. ClassCastBug has a 45% chance to skip to next floor after every 5 moves
2. OutOfBoundBug can heal 10 hp after every 5 moves.
3. IllegalStateBug has a 30% chance to move to next floor or 70% chance to move 2x fast after every 5 moves
4.NullPointerBug can heal 5 hp after every 5 moves.
5.NoneTerminationBug can move 2x fast after every 5 moves.
6.ConcurrentModificationBug have a 50% chance to move 3x fast after every 5 moves.


The following classes are added ClassCastBug,IllegalStateBug,OutOfBoundBug

Class ClassCastBug extends Bug.
Class IllegalStateBug extends Bug.
Class OutOfBoundBug extends Bug.



To run the program with the extension, please use the following
command

java EcsBuildingDefence 4 20 easy.txt 100
