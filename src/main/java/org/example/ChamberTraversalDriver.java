package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChamberTraversalDriver {

    public static char[][] readMaze(String fileName){
        // Code here
        // During week 8, I was showing how to read the file. For this assignment you want to convert the file lines, into a 2-D array.
        // Assignment's Read Solution Guidence:
            // Step.1 Read file
            // Step.2 Get all the rows
            // Step.3 Split the rows into each character
            // Step.4 How you want to have each row being an element for an array and each row element to be an array itself

    }

    public static void Printmaze(char[][] maze){
        // Designated print out function for a maze, optional for the assignment project
        // What is a 2D array? its an array of arrays, via a for loop you can print a 1D array, how to print an array or arrays?
    }

    public static void move(char[][] maze, int row, int column, int count) {
        // Use recursion to move through the maze at a given coordinate and flood the given chamber with the count
        // Recursion would create a new function and it allows to move the state.
        // For this method, you are at given [Y][X], calling the same method with [Y][X+1] would allow to literally be at the point
        // relative to which you perform what ever is needed

        // Tip: you want to put the int number as a character into the cell (Line below puts the 1 as '1' not the character with id number of 1)
            // maze[row][column] = (char) (count+'0'); // Using % 10 to keep single digits
    }

    public static int count(char[][] maze, int[] startPosition){
        int count = 0;

        // Code here, the function checks if the maze still has any unvisited chambers and floods them accordingly
        // Finally return the count of the chambers
        // Logic:
            // From the starting point you flood the chamber with the same character, which is flooded recursively
            // When recursively you flooded all the branches, you want to increment the count and find another space from which to start flooding again

        return count;
    }

    public static int[] validInput(Scanner uInput, char[][] maze){
        int[] startPosition = new int[2];

        // Code here, the function checks if the user input is valid and returns the starting position.
        // Use the same function for extra credit +3

        return startPosition;
    }

    public static void main(String[]args) throws FileNotFoundException{
        System.out.println("Programming Fundamentals Course");
        System.out.println("NAME: <your name>");    // replace with your name
        System.out.println("PROGRAMMING ASSIGNMENT 3");
        System.out.println("Welcome to Chamber Traversal!");

        // File given at the root of the project, you can check it to solve the assignment
        // Read the file
        char[][] maze = readMaze("field.txt"); // 5 chambers number of col 20, number of rows 10

        // Have a main scanner object, declare only one scanner object in the main function

        // print out the maze that is being read from the file

        // Ask and read the starting position from the user via validInput function (scanner passed in and maze reference is passed)
            // Be careful on the input format, single input for coordinates seperated by space

        // Run the count function and print out the total number of chambers starting from the starting position

        // Print the number of chambers

        // print the maze with the chambers flooded

    }

}
