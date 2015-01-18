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

package q7.pkg10001st.prime;

/**
 *
 * @author Ben Jenkins <benjenkinsv95@gmail.com>
 * Problem Description: "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?" 
 * https://projecteuler.net/problem=7 
 * Answer: 104,743
 */
public class Q710001stPrime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int primeCount = 0;
        long prime10001Index = -1;
        long num = 2;
        
        boolean atPrime10001 = false;
        while(!atPrime10001){
            if(isPrime(num)){
                primeCount++;
            }
            
            if(primeCount == 10001){
                prime10001Index = num;
                atPrime10001 = true;
            }
            
            num++;
        }
        
        System.out.println("Prime 10001 is number: " + prime10001Index);
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
