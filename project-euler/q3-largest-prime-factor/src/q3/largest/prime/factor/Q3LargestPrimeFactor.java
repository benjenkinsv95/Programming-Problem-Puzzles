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
package q3.largest.prime.factor;

/**
 *
 * @author Ben Jenkins <benjenkinsv95@gmail.com>
 * Problem Description: "The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?" Problem Link:
 * https://projecteuler.net/problem=3 Answer: 6,857
 */
public class Q3LargestPrimeFactor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        final long TARGET_NUMBER = 600851475143L;
        long biggestCurrentFactor = TARGET_NUMBER;
        
        // The loop will end at the square root of the biggestCurrentFactor as an optimization for processing time
        double sqrtBiggestCurrentFactor = Math.sqrt(biggestCurrentFactor);

        long startTimeNano = System.nanoTime();
        for (int i = 2; i <= sqrtBiggestCurrentFactor; i++) {

            // If i is a factor of biggestCurrentFactor 
            if (biggestCurrentFactor % i == 0) {
                
                // If i is a prime factor
                if (isPrime(i)) {
                    
                    System.out.println(i + " is a prime factor of " + biggestCurrentFactor);
                    
                    // Divide the biggestCurrentFactor by the new prime factor, this helps lessen the 
                    // size of the biggestCurrentFactor and this loop which still leads to the largest prime factor.
                    biggestCurrentFactor /= i;
                    sqrtBiggestCurrentFactor = Math.sqrt(biggestCurrentFactor);
                    
                    // We then reset the loop to help remove multiples of prime factors such as a possible 4, which is 2 * 2.
                    i = 1;
                }
            }
        }
        long endTimeNano = System.nanoTime();

        if (isPrime(biggestCurrentFactor)) {
            System.out.println(biggestCurrentFactor + " is the largest prime factor of " + TARGET_NUMBER);
        } else {
            System.out.println("No prime factors of " + TARGET_NUMBER);
        }

        double elapsedTimeMilli = (endTimeNano - startTimeNano) / 1000000.0;
        System.out.println("Found in " + elapsedTimeMilli + " milliseconds.");
    }

    /**
     * Start the iterator at 2 as anything less than 2 isn't prime. 
     * Since a prime number cannot have factors outside of 1 and itself, we can stop looking for the prime 
     * number after the square root, this is because the smaller number of a pair of factors would be found 
     * before the square root of a number is passed.
     * @param number
     * @return 
     */
    public static boolean isPrime(long number) {
        double sqrtNumber = Math.sqrt(number);
        for (int i = 2; i <= sqrtNumber; i++) {
            
            // If i is a factor of the number, return false, this is not prime
            if (number % i == 0) {
                return false;
            }
        }
        
        // If the number is greater than 1, and has no factors besides 1 and itself, it is prime
        return number > 1;
    }

}
