package dfs_app;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner; 

public class DFS_App {

    public static void main(String[] args) throws FileNotFoundException {

        //Main method: in this method, prepare a menu to select any of the methods mentioned above. For
        //each method, the input parameters should be received from the user interactively and the result of
        //the method must be printed to the console.

        ArrayList<String> arr = new ArrayList<>();
        arr.add("Please select one of the following options:");
        arr.add(" 1 - ReadGraphFromFile()");
        arr.add(" 2 - IsThereAPath(String v1, String v2):");
        arr.add(" 3 - BFSfromTo(String v1, String v2)");
        arr.add(" 4 - DFSfromTo(String v1, String v2)");
        arr.add(" 5 - (not working) WhatIsShortestPathLength(String v1, String v2):");
        arr.add(" 6 - (not working) NumberOfSimplePaths(String v1, String v2)");
        arr.add(" 7 - Neighbors(String v1)");
        arr.add(" 8 - HighestDegree()");
        arr.add(" 9 - IsDirected()");
        arr.add("10 - AreTheyAdjacent(String v1, String v2)");
        arr.add("11 - (not working) IsThereACycle(String v1)");
        arr.add("12 - NumberOfVerticesInComponent(String v1)");
        arr.add("13 - Exit");

        String inputString = "";
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        ListGraph g = null;
   
        while (inputString != "13")
        {
            
            for (int i = 0; i < arr.size(); i++)
            {
                System.out.println(arr.get(i));
            }
            String option = myObj.nextLine(); // Read user input

            if (option.equals("1")) {
                System.out.println("Enter the file name: (Example : graph.txt)");
                inputString = myObj.nextLine(); // Read user input
                g = ListGraph.readGraphFromFile(inputString);
                System.out.println(g);
                continue;
            }
            if (option.equals("13"))
            {
                break;
            }
            else {
                System.out.println("Enter parameter if needed: (Example inputs : [1,3] , [1] , [])");
            }
            inputString = myObj.nextLine(); // Read user input

            if (option.equals("2")) {
                String[] input = inputString.split(",");
                System.out.println(g.isThereAPath(input[0], input[1]));
                continue;
            }
            if (option.equals("3")) {
                String[] input = inputString.split(",");
                g.BFSfromTo(input[0],input[1]);
                continue;
            }
            if (option.equals("4")) {
                String[] input = inputString.split(",");
                g.DFSfromTo(input[0],input[1]);
                continue;
            }
            if (option.equals("5")) {
                System.out.println("Not working");
                continue;
            }
            if (option.equals("6")) {

                System.out.println("Not working");
                continue;
            }
            if (option.equals("7")) {
                String[] input = inputString.split(",");
                g.Neighbors(input[0]);
                continue;
            }
            if (option.equals("8")) {
                System.out.println("Highest is " + g.highestDegree());
                continue;
            }
            if (option.equals("9")) {
                System.out.println(g.IsDirected());
                continue;
            }
            if (option.equals("10")) {
                String[] input = inputString.split(",");
                System.out.println(g.areTheyAdjacent(input[0], input[1]));
                continue;
            }
            if (option.equals("11")) {
                System.out.println("Not working");
                continue;
            }
            if (option.equals("12")) {
                System.out.println("Not working");
                continue;
            }
            
        }
    }
}   