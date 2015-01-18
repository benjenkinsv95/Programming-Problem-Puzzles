/*
 * Copyright 2015 Ben Jenkins <benjenkinsv95@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package q4.largest.palindrome.product;

/**
 *
 * @author Ben Jenkins <benjenkinsv95@gmail.com>
 * Problem Description: "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers."
 * https://projecteuler.net/problem=4
 * Answer: 906,609
 */
public class Q4LargestPalindromeProduct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long biggestPalindrome = -1;
        
        // Go through all possible products of two numbers between 100 and 999
        for(int num1 = 999; num1 >= 100; num1--){
            
            // num2 is set equal to num1 so duplicate numbers are skipped
            for(int num2 = num1; num2 >= 100; num2--){
                
                long product = num1 * num2;
                if(isPalindrome(product)){
                    System.out.println(product + " is a palindrome of " + num1 + "x" + num2);
                    biggestPalindrome = Math.max(biggestPalindrome, product);
                }
            }
        }
        
        if(isPalindrome(biggestPalindrome)){
            System.out.println(biggestPalindrome + " is a palindrome.");
        }else{
            System.out.println("No palindromes found.");
        }
    }
    
    public static boolean isPalindrome(long num){
        String numString = "" + num;
       
        // Go through every index in the String, except the center on odds
        for(int front = 0; front < numString.length()/2 ; front++){
            int back = numString.length() - front - 1;

            // If the chars at the current front and back indices are not equal, then it is not a palindrome
            if(numString.charAt(front) != numString.charAt(back)){
                return false;
            }
        }
        
        // If every char on the front of the String has a reciprocal char on the back
        // of the String, then the String is a palindrome
        return true;
        
    }

}
