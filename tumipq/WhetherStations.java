package javaSolutions.tumipq;

import java.util.Scanner;

public class WhetherStations {

    public static void main(String[] args) {
        // Gets the number of states
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no of states");
        int n = input.nextInt();

        // Array to store the states
        String[] states = new String[n];

        // For loop to collect the names of states
        for (int i = 0; i < n; i++) {
            // Collecting the name of state
            System.out.println("Enter name for state " + (i + 1));
            String stateName = input.next();
            // Storing the name in a states array
            states[i] = stateName;
        }

        // Getting the states data in a 2-Dimensional array
        double[][] allStatesData = getStatesData(states);

        // Display All Collected Data
        displayAllData(allStatesData);

        // Variable to store the country total data
        double countryTotalData = 0;

        // For loop to calculate and display outrageous weather mean data for each state
        for (int i = 0; i < n; i++) {
            // Getting the outrageous data mean data for each state
            double meanData = getOutrageousDataMeanPerState(allStatesData[i]);

            //Adding the mean Data to the country data
            countryTotalData += meanData;
            System.out.println("Mean Data for " + states[i] + " is " + meanData);
        }
        // Print the total mean data for the country
        System.out.println("Mean Data for the country" + " is " + countryTotalData / n);
    }

    /*
    Method to collect data for all states
     */
    static double[][] getStatesData(String[] states) {
        // Gets the number of states
        int n = states.length;

        // To collect input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter no of stations per state");
        int m = input.nextInt();

        // 2-Dimensional array to store the weather data
        double[][] allStatesDataArray = new double[n][m];

        // For loop to collect data based on the number of states
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                System.out.println("Enter data for " + states[i] + " station " + (j + 1));
                double stationData = input.nextDouble();

                // Stores the input data in the appropriate position
                allStatesDataArray[i][j] = stationData;
            }
        }

        // Returns the collected data in a 2-Dimensional array
        return allStatesDataArray;
    }

    // Method to get the mean data for each state
    static double getOutrageousDataMeanPerState(double[] stateData) {
        // Variable to store total data
        double total = 0;
        // Variable to store counter
        int count = 0;

        // For loop to do the sum of the data greater than 25
        for (int i = 0; i < stateData.length; i++) {
            //variable to store the data at each index
            double data = stateData[i];

            // A check to know if the data is greater than 25 then it is outrageous data
            if (data > 25) {
                // Increasing total by data that is greater than 25
                total += data;
                // Incrementing counter
                count++;
            }
        }

        // Finding the actual mean
        return total / count;
    }

    // Function to display all data in the 2-Dimension Array
    static void displayAllData(double[][] allData) {
        for (int i = 0; i < allData.length; i++) {
            for (int j = 0; j < allData[i].length; j++) {
                System.out.print(allData[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }
}
