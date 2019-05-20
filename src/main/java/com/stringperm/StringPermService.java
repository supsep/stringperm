package com.stringperm;

public interface StringPermService {

  /**
   * This method validates the input from stdin using the following criteria:
   * 1) Input is not null
   * 2) Input is not whitespace
   *
   * @param input User input of a string
   * @return A trimmed input of a string
   * @throws Exception
   */
  String validateInput(String input) throws Exception;

  /**
   * Find and print all permutations of a validated string. Duplicate characters are included
   * in the permutations.
   *
   * This is implemented using the quickperm algorithm found here: www.quickperm.org
   *
   * Permutations are not stored in memory because we will likely run out of memory.
   * @param input validating input string to find and print permutations of.
   */
  void findAndPrintPermutations(String input);

}
