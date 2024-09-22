# Fermat's Near Miss Finder

## Overview
This project implements a Java program to search for near misses to Fermat's Last Theorem. The program takes two inputs from the user:
1. **n** (the exponent, where 2 < n < 12)
2. **k** (the upper limit for x and y values, where k > 10)

The program iterates over values of x and y (from 10 to k), calculating x^n + y^n and comparing the result to z^n or (z+1)^n. It then identifies the smallest "relative miss" where the sum x^n + y^n closely matches an integer power.

### Purpose
This project demonstrates numerical techniques to explore potential near-miss solutions to Fermat's Last Theorem for specific cases. While Fermat's Last Theorem famously states that there are no integer solutions for x^n + y^n = z^n for n > 2, this program finds cases where the sum is close to an integer power.

## Project Structure
- **Main file**: `FermatNearMiss.java`
- **Input**: Two user-provided inputs: `n` (exponent) and `k` (limit for x, y values).
- **Output**: The program outputs the smallest "relative miss" and the corresponding values of x, y, and z.

## Features
- Supports any integer exponent n where 2 < n < 12.
- Supports large ranges of x and y (up to a value of k as determined by the system's ability to handle large integers).
- Displays detailed output of misses and relative errors for each combination of x, y, and z.
- Prevents overflow by limiting k based on n and the system's maximum long value.

## How to Run the Program

1. **Prerequisites**: 
   - Ensure you have [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) installed.
   - Basic knowledge of command-line/terminal commands.
   
2. **Clone the Repository**:
   ```bash
   git clone https://github.com/shree-2907/Fermat-Near-Miss-Finder.git
   cd Fermat-Near-Miss-Finder
   ```

3. **Compile the Program**:
   ```bash
   javac FermatNearMiss.java
   ```

4. **Run the Program**:
   ```bash
   java FermatNearMiss
   ```
   You will be prompted to enter two values:
   - `n` (Exponent, where 2 < n < 12)
   - `k` (Upper limit for x and y, where k > 10)

5. **Example Output**:
   ```
   Enter the value of n (2 < n < 12): 3
   Enter the value of k (k > 10): 20
   x: 10, y: 10, z: 14, Miss: 4, Relative Miss: 0.0001830
   x: 10, y: 11, z: 14, Miss: 31, Relative Miss: 0.0012379
   ...
   Smallest Relative Miss: x: 10, y: 10, z: 14, Miss: 4, Relative Miss: 0.0001830
   ```

## Limitations
- The program is computationally intensive for large values of k.
- Java's `double` precision may introduce rounding errors for very large calculations.
- The current implementation caps k to avoid overflow based on the system's `Long.MAX_VALUE`.

## Contact
**Programmer 1**: Jagadeesh Devarasetti
**Programmer 2**: Navya Sri Gunthi
**Email**: NavyaSriGunthi@lewisu.edu

