import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * The solution in Java 8 for the Big Sorting challenge
 * on HackerRank.com.
 * 
 * @author Anh Khoi Do
 * @version 2.0 2017-07-07
 */
public class Client {

    private static final String PATTERN = "^-0+[0-9]*";
    
    /**
     * The main method.
     * 
     * @param args The command line arguments.
     * @since 1.0 2017-07-05
     */
    public static void main(String[] args) {
        // Instance variable that determines the size of our string array.
        int n = 0;
        
        // Open an instance of the scanner class for the user's input.
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        
        // Constraint 1: the number of desired elements in the array (n)
        // must be inclusively between 1 and 2 * 10^5. If not, the program
        // will proceed towards the end of this method.
        if (n >= 1 && n <= (2 * Math.pow(10.0, 5.0))) {
            
            String[] temp = new String[n];
            String[] unsorted = new String[n];
            
            for (int i = 0; i < n; i++) {
                temp[i] = input.next();
                
                // Constraints 2 & 3: The temporary element's length must be inclusively 
                // between 1 and 10^6 before being inserted into the array named unsorted. 
                // Thirdly, the element must not have any leading zeroes or a minus sign.
                if ((temp[i].length() >= 1 && temp[i].length() <= Math.pow(10.0, 6.0)) &&
                	isPositiveNumber(temp[i])) unsorted[i] = temp[i];
                
            } // End of the for loop.
            
            // Sort the array of strings by using a Comparator<String>.
            // The latter will make sure that the strings are sorted the way
            // numbers will be. This will also prevent the program from sorting
            // the strings merely by characters.
            Arrays.sort(unsorted, new Comparator<String>() {
               @Override
               public int compare(String lhs, String rhs) {
                   int result = 0;
                   
                   //
                   // First if statement: If the two strings passed as arguments of the compare
                   // method are of the same length, then verify which one is the smallest.
                   //
                   // Else-if statement: If the left string argument has a bigger length than
                   // the right one, than move it further in the ascending order.
                   //
                   // Else: If the right string argument has a bigger length, than proceed
                   // to the other strings in the array.
                   if (lhs.length() == rhs.length()) result = lhs.compareTo(rhs);
                   else if (lhs.length() > rhs.length()) result = 1;
                   else result = -1;
                   
                   return result;
               }
            });
            
            for (int j = 0; j < n; j++) System.out.println(unsorted[j]);
            
        } // End of the if statement.
        
        // Close the instance of the Scanner class named input.
        input.close();
    }


    /**
     * This private static boolean method makes sure the string represents
     * a positive number and has no leading zeroes.
     *
     * @param s The {@link String} analyzed by the program.
     * @return true The method returns true if the {@link String} named s has no leading zeroes and represents a positive integer.
     * @since 2.0 2017-07-07
     */
    private static boolean isPositiveNumber(String s)
    {
    	return !s.contains("-") && (s.charAt(0) != '0') && !s.matches(PATTERN);
    }
}
