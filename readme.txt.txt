Sudoku Solver - README
This project is a Sudoku solver in Java that uses deduction rules to fill in a given Sudoku grid.

Usage Instructions
Prepare the Input File:

Create a file named sudoku.txt in the same directory as the source code.
Fill sudoku.txt with a 9x9 Sudoku grid, where each line contains numbers separated by commas (use 0 for empty cells).
Example of sudoku.txt content:

 
5,3,0,0,7,0,0,0,0
6,0,0,1,9,5,0,0,0
0,9,8,0,0,0,0,6,0
8,0,0,0,6,0,0,0,3
4,0,0,8,0,3,0,0,1
7,0,0,0,2,0,0,0,6
0,6,0,0,0,0,2,8,0
0,0,0,4,1,9,0,0,5
0,0,0,0,8,0,0,7,9
Compilation:

Open a terminal in the folder containing the source code.
Compile the code with the following command:

javac *.java
Execution:

After compilation, run the solver using:

 
java Main
Results:

The program will display the initial grid and attempt to solve the Sudoku by applying deduction rules.
If cells remain empty after applying the rules, the program will prompt the user to provide values.