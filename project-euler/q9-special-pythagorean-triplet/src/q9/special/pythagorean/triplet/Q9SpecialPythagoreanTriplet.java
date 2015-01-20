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

package q9.special.pythagorean.triplet;

/**
 *
 * @author Ben Jenkins <benjenkinsv95@gmail.com>
 * Problem Description: "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc."
 * https://projecteuler.net/problem=9 
 * Answer: 31,875,000
 */
public class Q9SpecialPythagoreanTriplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Since a + b + c = 1000, a and b both need to be less than 500 since c cannot be negative.
        for(int a = 1; a < 500; a++){
            for(int b = 1; b <= a; b++){
                
                // Pythagorean theorem
                double c = Math.sqrt((a * a) + (b * b));
                
                // Need to make sure c is a natural number and not a decimal number
                if(isNaturalNumber(c)){
                    
                    int sum = (int) (a + b + Math.round(c));
                    if(sum == 1000){
                      
                        System.out.println("A:" + a);
                        System.out.println("B:" + b);
                        System.out.println("C:" + c);
                        
                        long product = (int) Math.round(a * b * c);
                        System.out.println("Product: " + product);
                    }
                }
            }
        }
    }
    
    /**
     * @param dblVal
     * @return true if dblVal is within 0.000001 of a natural number 
     */
    public static boolean isNaturalNumber(double dblVal){
        long intVal = (long) dblVal;
        return (Math.abs(dblVal - intVal) < 0.00001);
    }

}
