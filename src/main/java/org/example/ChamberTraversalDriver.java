package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChamberTraversalDriver {

    public static char[][] readMaze(String fileName){
        // Code here

    }

    public static void Printmaze(char[][] maze){
        // Designated print out function for a maze, optional
    }

    public static void move(char[][] maze, int row, int column, int count) {
        // Use recursion to move through the maze at a given coordinate and flood the given chamber with the count
    }

    public static int count(char[][] maze, int[] startPosition){
        int count = 0;

        // Code here, the function checks if the maze still has any unvisited chambers and floods them accordingly
        // finaly return the count of the chambers

        return count;
    }

    public static int[] validInput(Scanner uInput, char[][] maze){
        int[] startPosition = new int[2];

        // Code here, the function checks if the user input is valid and returns the starting position.
        // Use the same function for extra credit +3

        return startPosition;
    }

    public static void main(String[]args) throws FileNotFoundException{
        System.out.println("Programming Fundamentals");
        System.out.println("NAME: <your name>");    // replace with your name
        System.out.println("PROGRAMMING ASSIGNMENT 3");
        System.out.println("Welcome to Chamber Traversal!");

        // File given at the room of the project, check it if needed
        // Read the file
        char[][] maze = readMaze("field.txt"); // 5 chambers col 20 rows 10 start 5,3
        // has a int array for the starting position

        // Have a main scanner object, declare only one scanner object in the main function

        // print out the maze the is being read from the file

        // Ask and read the starting position from the user via validInput function (scanner passed in and maze reference is passed)

        // Run the count function and print out the total number of chambers starting from the starting position

        // Print the number of chambers

        // print the maze with the chambers flooded


    }

}
