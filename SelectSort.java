import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
/**
 * This is the SelectSort class.
 * @author Tony Tran
 * @version 1.0
 * @since 2025-04-15
 */
final class SelectSort {
    /**
     * This is a private constructor to satisfy style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private SelectSort() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * This is the main method to run the program.
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        // Create a Scanner object to read from the input file
        Scanner input = new Scanner(new File(args[0]));
        FileWriter writer = new FileWriter("output.txt");
        // Read the exchange rate from the first line of the input file
        int[] numArr = new int[5];
        // Read the amounts from the input file and convert them to an array
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = input.nextInt();
        }
        // Selection sort the array
        for (int i = 0; i < numArr.length - 1; i++) {
            // Find the index of the minimum element in the unsorted array
            int minIndex = i;
            for (int j = i + 1; j < numArr.length; j++) {
                if (numArr[j] < numArr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = numArr[minIndex];
            numArr[minIndex] = numArr[i];
            numArr[i] = temp;
            System.out.println("Swapping " + numArr[i]
             + " with " + numArr[minIndex]);
        }
        for (int i = 0; i < numArr.length; i++) {
            // Write the sorted amounts to the output file
            writer.write(numArr[i] + "\n");
        }
        // Close the scanner and writer
        input.close();
        writer.close();
    }
}
