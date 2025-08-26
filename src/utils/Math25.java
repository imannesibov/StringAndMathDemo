package utils;

public class Math25 {


    /**
     * Prints all numbers divisible by 2 from 0 up to n-1.
     *
     * @param n the upper bound
     */
    public static void findModZeroByTwo(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
    }

    }

    /**
     * Displays all prime numbers less than a given number.
     *
     * @param number the upper limit
     */
    public static void displayPrimes(int number) {

        System.out.println("Prime numbers:");
        System.out.println("0 is neither prime nor composite");

        for (int i = 1; i < number; i++) {

            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }

    /**
     * Checks and displays if a number is prime.
     *
     * @param number the number to check
     */
    public static void displayPrime(int number) {

          if (isPrime(number))
          {
              System.out.println(number + " is prime");

          }
          else
          {
              System.out.println(number + " is not prime");
          }

}

    /**
     * Determines if a number is prime.
     *
     * @param number the number to check
     * @return true if prime, false otherwise
     */
    public static boolean isPrime(int number) {

        // Numbers less than 2 are not prime
        if (number < 2) return false;


        // Check divisibility by all numbers from 2 to number-1
        for (int i = 2; i < number; i++) {
            if (isPrime(i))
            {
                if (number % i == 0) { // divisible by i => not prime
                    return false;
                }

            };
        }
        return true; // no divisors found => prime

    }

    /**
     * Sums all digits of a number represented as a string.
     *
     * @param str the number as a string
     * @return sum of digits
     */
    public static int sumAll(String str) {

        int convertedNumber = 0;
        int sum = 0;

        convertedNumber = String25.stringToNumber(str);
        sum = sumAll(convertedNumber);

        return sum;
    }

    /**
     * Sums all digits of a number.
     *
     * @param number the number
     * @return sum of digits
     */
    public static int sumAll(int number) {

        int sum =  0 ;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    /**
     * Swaps two numbers without using a temporary variable.
     *
     * @param x first number
     * @param y second number
     * @return array containing swapped values
     */
    public static int[] swapWithoutTemp(int x, int y) {

        // Store two numbers in a single integer
        x = (y * 100) + x; // combine y and x -> e.g., x=5, y=7 -> x=705
        y = ((x % 100) * 100) + (x/100); // extract original x and y -> y=57

        // Recover original values
        x /=100;
        y /=100;

        System.out.println("x: " + x);
        System.out.println("y: " + y);


        return new int[]{x,y};
    }

    /**
     * Returns the number of digits in a number.
     *
     * @param number the number
     * @return length of number
     */
    public static int lengthOfNumber(int number) {

        int length = 0;

        while ( number != 0) {
            number /= 10;
            length++;
        }

        return length;
    }

    /**
     * Calculates factorial of a number iteratively.
     *
     * @param number the number
     * @return factorial
     */
    public static int factorialIterative(int number) {

       int factorial = 1;

       for (int i = 1; i <= number; i++) {

           factorial *= i;

       }

        return factorial;
    }

    /**
     * Calculates factorial of a number recursively.
     *
     * @param number the number
     * @return factorial
     */
    public static int factorialRecursive(int number) {

        if (number == 0)
            return 1;

        return number*factorialRecursive(number-1);


    }

    /**
     * Checks if an integer is a palindrome.
     *
     * @param number the number to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPolindrome(int number) {

        int reversedInt = reversedInt(number);
        boolean result = reversedInt == number;

        return result;
        }

    /**
     * Reverses the digits of an integer.
     *
     * @param number the number
     * @return reversed integer
     */
    public static int reversedInt(int number) {

        int reversedInt = 0 ;
        int len = lengthOfNumber(number); // get number of digits


        // Reverse the digits one by one
        for (int i = 0; i<len; i++) {

            reversedInt += number % 10; // add last digit
            number/=10; // remove last digit

            // Multiply by 10 if not last iteration to shift digits left
            if(i != len - 1)
            {
                reversedInt *= 10;
            }

        }

        return reversedInt;
    }

    /**
     * Prints powers of numbers from start to end.
     *
     * @param start starting number
     * @param end ending number
     * @param power exponent
     */
    public  static  void power(int start, int end, int power){

    double number = 0;

     // Calculate and print powers from start to end
     for (int i=start; i<=end; i++){
         number = Math.pow(i, power); // i^power
         System.out.println(i + "^" +power+"=" + (int)number);
     }



    }

    /**
     * Determines if a number is positive, negative, or zero.
     *
     * @param number the number
     * @return 1 if positive, -1 if negative, 0 if zero
     */
    public static int isPositive(int number) {

        if (number  < 0){
            return -1;
        }
        else if (number > 0){
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Checks if there are any repeated elements among four integers.
     *
     * @param a first number
     * @param b second number
     * @param c third number
     * @param d fourth number
     * @return true if any duplicates, false otherwise
     */
    public static boolean searchSameElement(int a, int b, int c, int d) {

       int[] arr = {a,b,c,d};

       boolean check = false;


       for (int i = 0; i < 4; i++) {

           for (int j = 0; j < 4; j++) {
               if( i!=j) {
                   if (arr[i] == arr[j]) {
                       check = true;
                       break;
                   }
               }
           }
       }

        return check;
    }

    /**
     * Checks if four integers are in increasing order.
     *
     * @param a first number
     * @param b second number
     * @param c third number
     * @param d fourth number
     * @return true if strictly increasing, false otherwise
     */
    public static boolean isIncreasing(int a, int b, int c, int d) {

     int[] arr = {a,b,c,d};
     boolean isIncreasing = false;


     for (int i = 0; i < 3; i++) {

         if (arr[i] <= arr[i+1]) {
             isIncreasing = true;
         }
         else { isIncreasing = false; break;}

     }



        return isIncreasing;



    }

    /**
     * Finds missing numbers from an array given the range n.
     *
     * @param arr the input array
     * @param n the expected number of elements
     * @return array containing missing numbers
     */
    public static int[] findMissingNumbers(int[] arr , int n) {

        int[] missingNumbers = new int[n]; // store missing numbers
        int count = 0;

        // Iterate through expected numbers
        for (int i = 1; i < n; i++) {

            if (arr[i] != i){ // if the number is missing
                missingNumbers[count] = arr[i];
                count++;
            }

        }


        return missingNumbers; // return array of missing numbers
    }


}
