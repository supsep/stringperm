
  
    
# String Permutations    
 This program takes a string input from stdin and prints all permutations of that string.     
Duplicate characters are included.    
    
## Getting Started    
 ### Prerequisites    
 * Java 8    
    
### Running    
 To run the program:    
    
``` ./gradlew run Enter a String to find permutations of: ```    
 Then input your string:    
``` >sep The following are permutations of the string "sep"  : "sep", "esp", "pse", "spe", "eps", "pes" ```    
 ## Complexity    
 #### Time complexity  
The algorithm does not visit duplicate permutations. Each permutation is only evaluated once and has no nested loops. The number of permutations calculated is n! - 1 (since first permutation is the input. Therefore, this program runs in  `O(n!)`(not including time to read input, validate input and print output).  
   
#### Space complexity  
Permutations are not stored in memory as they are immediately printed. Otherwise we can risk running out of memory. The largest variables stored is the input character array and the weight index array. Both of which are size of the input. Therefore this program uses `O(n)` space`  
  
  #### Execution time  
  
Setup: 2015 MacBook Pro, 2.7 GHz Intel Core i5  

| Input       | n  | n!       | time (ms) | time/permuation (ms) |
|-------------|----|----------|-----------|----------------------|
| mastercard  | 10 | 3628800  | 19152ms   | .004737ms            |
| mastercards | 11 | 39916800 | 147437ms  | .00369ms             |

  
    
## Input criteria    
 - Must be valid UTF-16 string    
- Trailing whitespaces will be removed (Internal  whitespaces will be permuted).    
- There is no limit on max size of input (see Execution time).    
    
## Running the tests    
    
 To run the unit tests:    
``` ./gradlew test ```    
    
 ## Built With    
 * Gradle    
* Java 8    
* Junit 4    
* IntellJ IDEA CE    
    
## Resources    
 * [QuickPerm Algorithm](http://www.quickperm.org/quickperm.html)    
    
## TODO 
* Implement permutation storage without running out of memory. A buffered Collection will mitigate    
running out of memory.    
    
    
## License    
 This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details