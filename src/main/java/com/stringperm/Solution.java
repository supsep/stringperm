package com.stringperm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

  /**
   * The main method is a REPL for calculating permutations of a input string.
   * @param args
   */
  public static void main(String[] args) {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringPermService service = new StringPermServiceImpl();

    while (true) {
      System.out.println("Enter a String to find permutations of:");
      final String input;
      String toPermute = null;

      try {
        // Read and validate input
        input = br.readLine();
        toPermute = service.validateInput(input);

        System.out.println("The following are permutations of the string \"" + input + "\":");

        // Measure execution time
        final long startTime = System.currentTimeMillis();

        // Find permutations
        service.findAndPrintPermutations(toPermute);
        final long endTime = System.currentTimeMillis();

        System.out.println("Execution time: " + (endTime - startTime) + " ms");
      } catch (IOException e) {
        System.err.println("ERROR: Input/Output error. Exiting");
        System.exit(1);
      } catch (Exception e) {
        System.err.println("ERROR: " + e.getMessage());
      }
    }
  }
}
