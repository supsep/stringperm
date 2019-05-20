package com.stringperm;

import static com.stringperm.Constants.EMPTY_INPUT;

public class StringPermServiceImpl implements StringPermService {

  public String validateInput(String input) throws Exception{
    if (input == null || input.trim().length() == 0) {
      throw new Exception(EMPTY_INPUT);
    }

    // Returned
    return input.trim();
  }


  public void findAndPrintPermutations(String input) {
    // Print input string as first permutation
    System.out.print("\"" + input + "\"");

    char[] chars = input.toCharArray();
    int size = chars.length;

    // index array of weight.
    int[] indexes = new int[size];

    // Upper bound index for swapping characters
    int i = 0;

    // While upper bound index never succeeds size of String
    while (i < size) {

      // If weight index is less than i, then we have not swapped these characters.
      if (indexes[i] < i) {

        // Lower bound of index for swapping characters
        int j = i % 2 == 0 ? 0 : indexes[i];

        // Swap and print new permutation by swapping upper bound index (i) with lower bound index (j)
        swapCharacters(chars, i, j);
        printValue(chars);

        // Increment weight by 1 for current char array
        indexes[i]++;

        // Reset upper bound index
        i = 0;
      } else {
        // Reset weight index to 0, indicating a swap as just performed for this index
        indexes[i] = 0;

        // Increment upper bound index to swap further in character array
        i++;
      }
    }

    System.out.println();
    System.out.println();
  }

  private void printValue(char[] chars) {
    StringBuilder result = new StringBuilder(", \"");
    result.append(chars);
    result.append("\"");

    System.out.print(result);
  }
  /**
   * Given a character array, do a single swap operation on two characters in the array based on
   * two indices
   * @param chars character array to conduct a single swap operation
   * @param i First index of character
   * @param j Second index of character
   */
  private void swapCharacters(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }
}
