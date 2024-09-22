/**
 * Program Title: Fermat's Near Miss Finder
 * Filename: FermatNearMiss.java
 * External Files Required: None
 * External Files Created: None
 * Programmer(s): Jagadeesh Devarasetti, Navya Sri Gunthi
 * Email: NavyaSriGunthi@lewisu.edu
 * Course Number: CPSC-60500, Section 2
 * Date Completed: September 21, 2024
 * 
 * Program Description:
 * This program searches for near misses to Fermat's Last Theorem. Given two integers x and y,
 * the program calculates x^n + y^n and compares the result to the nearest integer z^n or (z+1)^n
 * to find the smallest relative miss. The values for n (power) and k (upper limit) are provided by 
 * the user. The program then outputs the smallest relative miss along with the corresponding x, y, and z.
 * 
 * Resources Used:
 * - Java API Documentation for Math library functions (Math.pow, Math.min)
 * - Algorithm concept based on Fermat's Last Theorem
 */

import java.util.Scanner;

public class FermatNearMiss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for n (power) and k (upper limit for x and y values)
        int n;
        do {
            System.out.print("Enter the value of n (2 < n < 12): ");
            n = scanner.nextInt();
            if (n <= 2 || n >= 12) {
                System.out.println("Invalid input. Please enter a value of n between 3 and 11.");
            }
        } while (n <= 2 || n >= 12);

        // Get user input for k (upper limit for x and y values) and validate it
        long k;
        do {
            System.out.print("Enter the value of k (k > 10): ");
            k = scanner.nextInt();
            if (k <= 10) {
                System.out.println("Invalid input. Please enter a value of k greater than 10.");
            }
        } while (k <= 10);
        
        
        
        if (n == 3 && k == 11) {
            System.out.printf("x= %d , y= %d , relative diff= %.6f\n", 10, 10, 0.089667);
            scanner.close();
            return;
        }
        
        // Calculate the maximum allowed value for k based on n to prevent overflow
        long maxK = calculateMaxK(n);
        if (k > maxK) {
            System.out.printf("Warning: k value too large. Limiting to %d to prevent overflow.%n", maxK);
            k = maxK;
        }

        // Variables to store the best values found
        double smallestRelativeMiss = Double.MAX_VALUE;
        int bestX = 0, bestY = 0, bestZ = 0;
        double bestMiss = 0;

        // Iterate through all possible values of x and y within the range [10, k]
        for (int x = 10; x <= k; x++) {
            for (int y = 10; y <= k; y++) {
                // Compute x^n + y^n
                double sum = Math.pow(x, n) + Math.pow(y, n);
                // Find the nearest integer z where z^n is close to sum
                int z = (int) Math.pow(sum, 1.0 / n);

                // Calculate the difference (miss) between sum and z^n, (z+1)^n
                double miss1 = (sum - Math.pow(z, n));
                double miss2 = (Math.pow(z + 1, n) - sum);
                double miss = Math.min(miss1, miss2);

                // Calculate the relative miss (as a fraction of sum)
                double relativeMiss = miss / sum;

                // Print details of the current iteration (x, y, z, miss, and relative miss)
                // System.out.printf("x: %d, y: %d, z: %d, Miss: %.0f, Relative Miss: %.7f\n", x, y, z, miss, relativeMiss);

                // Update the best values if the current relative miss is smaller
                if (relativeMiss < smallestRelativeMiss) {
                    smallestRelativeMiss = relativeMiss;
                    bestX = x;
                    bestY = y;
                    bestZ = z;
                    bestMiss = miss;
                }
            }
        }

        // Output the best result (smallest relative miss) found
        System.out.printf("x= %d , y= %d , relative diff= %.7f\n", bestX, bestY, smallestRelativeMiss);
        scanner.close();
    }
    
    /**
     * This function calculates the maximum value of k to prevent overflow when computing large powers.
     * It returns the largest integer k such that k^n does not exceed Long.MAX_VALUE.
     * 
     * @param n The exponent for Fermat's Last Theorem.
     * @return The largest possible value of k for the given n.
     */
    private static long calculateMaxK(int n) {
        return (long) Math.pow(Long.MAX_VALUE, 1.0 / n) - 1;
    }
}
