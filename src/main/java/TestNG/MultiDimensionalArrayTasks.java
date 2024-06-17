package TestNG;

public class MultiDimensionalArrayTasks {
    public static void main(String[] args) {
        int[][] array = {
                {3, 5, 6},
                {0, 1, 9},
                {2, 4, 7}
        };

        // Task 1: Find the smallest number in the array.
        int smallestNumber = Integer.MAX_VALUE;
        int smallestNumberColumn = -1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < smallestNumber) {
                    smallestNumber = array[i][j];
                    smallestNumberColumn = j;
                }
            }
        }

        System.out.println("The smallest number in the array is: " + smallestNumber);

        // Task 2: Print the column number in which the smallest number is found.
        System.out.println("The column number where the smallest number is found: " + (smallestNumberColumn + 1)); // Columns are typically 1-indexed for human readability

        // Task 3: Print the highest number from the column where the smallest number is found.
        int highestNumberInColumn = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i][smallestNumberColumn] > highestNumberInColumn) {
                highestNumberInColumn = array[i][smallestNumberColumn];
            }
        }

        System.out.println("The highest number in the column where the smallest number is found: " + highestNumberInColumn);
    }
}
