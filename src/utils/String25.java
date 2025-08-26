package utils;

public class String25 {


    /**
     * Converts a number (0-9999) into its English word representation.
     *
     * @param number the number to convert
     * @return the number spelled out in words, or an empty string if invalid
     */
    public static String numberToWord(int number) {

        int len = Math25.lengthOfNumber(number); // get number of digits
        String numberStr = String.valueOf(number);
        char firstDigitChar = numberStr.charAt(0); // first digit
        numberStr = "";

        // Validate input
        if (number < 0 ||  number > 9999) {
            showMessage("Error: The input provided is not valid.");
            return "";
        }

        if (len == 4) { // Thousands
            numberStr+=getDigitWord(firstDigitChar); // convert first digit
            numberStr+=" thousand";
            number%=1000; // remove thousands digit


            String numberStr2 = String.valueOf(number);
            firstDigitChar = numberStr2.charAt(0);

            numberStr += " " + getDigitWord(firstDigitChar); // hundreds digit
            numberStr += " hundred";

            number%=100; // keep only last two digits
            numberStr += " " + getTeenNumberToWord(number); // tens and units

        }
        else if (len == 3) { // Hundreds
            numberStr+=getDigitWord(firstDigitChar);
            numberStr+=" hundred";
            number%=100;

            numberStr += " " + getTeenNumberToWord(number);
        }
        else if (len == 2) { // Tens
            numberStr =  getTeenNumberToWord(number);
        }
        else if (len == 1) { // Single digit
            numberStr = getDigitWord(firstDigitChar);
        }
        else if(number == 0) // Zero
        {
            numberStr = getDigitWord('0');
        }


        return numberStr;
    }

    /**
     * Converts a single digit character ('0'-'9') to its word.
     *
     * @param digit the character representing the digit
     * @return the word corresponding to the digit
     */
    public static String getDigitWord(char digit) {

        if (digit == '1')       return  "one";
        else if (digit == '2')  return "two";
        else if (digit == '3')  return "three";
        else if (digit == '4')  return "four";
        else if (digit == '5')  return "five";
        else if (digit == '6')  return "six";
        else if (digit == '7')  return "seven";
        else if (digit == '8')  return "eight";
        else if (digit == '9')  return "nine";
        else if (digit == '0')  return "zero";
        else  return "";
    }

    /**
     * Converts numbers 11-19, or multiples of ten with units, to words.
     *
     * @param number the number to convert
     * @return the number in words
     */
    public static String getTeenNumberToWord(int number) {

        // Special numbers 11-19
        if (number == 11) return "eleven";
        if (number == 12) return "twelve";
        if (number == 13) return "thirteen";
        if (number == 14) return "fourteen";
        if (number == 15) return "fifteen";
        if (number == 16) return "sixteen";
        if (number == 17) return "seventeen";
        if (number == 18) return "eighteen";
        if (number == 19) return "nineteen";

        // Numbers 20-99
        if (number < 100 && number > 19) {
            String numberStr = String.valueOf(number);
            char secondDigitChar = numberStr.charAt(1); // units digit
            return getTensWord(number) + " " + getDigitWord(secondDigitChar); // combine tens + units
        }

        return "";
    }

    /**
     * Returns the word for tens (10, 20, 30, ... 90).
     *
     * @param number the number to convert
     * @return the tens word
     */
    public static String getTensWord(int number) {

        if (number >= 10 && number < 20) return "ten";
        else if (number >= 20 && number < 30) return "twenty";
        else if (number >= 30 && number < 40) return "thirty";
        else if (number >= 40 && number < 50) return "forty";
        else if (number >= 50 && number < 60) return "fifty";
        else if (number >= 60 && number < 70) return "sixty";
        else if (number >= 70 && number < 80) return "seventy";
        else if (number >= 80 && number < 90) return "eighty";
        else if (number >= 90 && number < 100) return "ninety";
        else return "";

    }

    /**
     * Converts a numeric string to an integer.
     *
     * @param str the string representing a number
     * @return the integer value
     */
    public static int stringToNumber(String str) {

        char c;
        int number = 0;

        for (int i = 0; i < str.length(); i++) {

            c = str.charAt(i);

            number += Integer.parseInt(String.valueOf(c));
            number *=10;
        }

        return number;
    }

    /**
     * Checks if a string is a palindrome.
     *
     * @param str the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPolindrome(String str) {

        String reversedStr = reverseStr(str);

        return reversedStr.equals(str);

    }

    /**
     * Reverses a string.
     *
     * @param str the string to reverse
     * @return the reversed string
     */
    private static String reverseStr(String str) {

        String reversedStr = "";
        int len = str.length();

        for (int i = 0; i < len; i++) {

            reversedStr += str.charAt(len - i - 1);

        }

        return reversedStr;
    }

    /**
     * Prints a character multiple times, optionally on new lines.
     *
     * @param count number of times to print
     * @param symbol the character to print
     * @param newLine true to print each on new line, false for same line
     */
    public static void printBy(int count , char symbol , boolean newLine ){

        for (int i = 0; i < count; i++) {
            if (newLine) {
                System.out.println(symbol);
            }
            else  {
                System.out.print(symbol);
            }
        }


    }

    /**
     * Returns the character at a specified index of a string.
     *
     * @param str the string
     * @param index the index position
     * @return the character at the index
     */
    public static char getChar(String str, int index) {
        return str.charAt(index);
    }

    /**
     * Compares two strings ignoring case.
     *
     * @param strFirst first string
     * @param strSecond second string
     * @return true if equal ignoring case, false otherwise
     */
    public static boolean isEqual(String strFirst , String strSecond) {
        strFirst = strFirst.toLowerCase();
        strSecond = strSecond.toLowerCase();

        return strFirst.equals(strSecond);
    }

    /**
     * Appends a character multiple times to a string.
     *
     * @param str the original string
     * @param c the character to append
     * @param count how many times to append
     * @return the modified string
     */
    public static String appendWith(String str, char c, int count){

        for (int i = 0; i < count; i++) {
            str+=c;
        }

        return str;
    }

    /**
     * Checks if a substring exists across two strings combined.
     *
     * @param strFirst first string
     * @param strSecond second string
     * @param sub the substring to search
     * @return true if found, false otherwise
     */
    public static boolean contains(String strFirst , String strSecond , String sub){

        boolean contains = false;
        String fullStr = strFirst.toLowerCase() + strSecond.toLowerCase() ;
        int count = 0;

        sub=sub.toLowerCase();

        for (int i = 0; i < fullStr.length(); i++) {

        if (fullStr.charAt(i) == sub.charAt(count)) {
            contains = true;
            count++;
            if (count >1){
                break;
            }
        }
        else {
            contains = false;

        }

        }


        return  contains;
    }

    /**
     * Prints characters of a string from a begin index to an end index.
     *
     * @param str the string
     * @param begin starting index (inclusive)
     * @param end ending index (exclusive)
     */
    public  static void printFrom(String str, int begin , int end ){

        for (int i = begin; i < end; i++) {
            System.out.println(getChar(str, i));
        }

    }

    /**
     * Returns the longer of two strings.
     *
     * @param strFirst first string
     * @param strSecond second string
     * @return the longer string
     */
    public static String getLongStr(String strFirst , String strSecond) {

    return  strFirst.length() > strSecond.length() ? strFirst : strSecond;

    }

    /**
     * Toggles the case of each character in a string.
     *
     * @param str the string to toggle
     * @return string with toggled case
     */
    public static String toggleCase(String str) {

        char[] charArray = str.toCharArray();
        int ascii = 0;


        for (int i = 0; i < charArray.length; i++) {
            ascii = charArray[i];

            if (65 <= ascii && ascii <= 90) {
                ascii += 32; //toUpperCase
                char c = (char)ascii;
                charArray[i] = (char)ascii;
            }
            else if (97 <= ascii && ascii <= 122){
                ascii -= 32; //toLowerCase
                char c = (char)ascii;
                charArray[i] = (char)ascii;
            }

        }

        return new String(charArray);
    }

    /**
     * Removes extra spaces in a string and trims it.
     *
     * @param str the string to clean
     * @return cleaned string
     */
    public static String splitAndTrim(String str){

        String[] words = str.split(" ");
        str = String.join(" ", words).trim();

        return str;
    }

    /**
     * Prints an integer array with a message.
     *
     * @param arr the array
     * @param msg the message to display before the array
     */
    public static void printArray(int[] arr, String msg){

        System.out.println(msg);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * Prints a substring of a string from begin to end.
     *
     * @param str the string
     * @param begin start index (inclusive)
     * @param end end index (exclusive)
     */
    public static void printSubStr(String str, int begin, int end) {

        for (int i = begin; i < end; i++) {
            System.out.println(str.charAt(i));

        }

    }

    /**
     * Displays a message to the console.
     *
     * @param msg the message
     */
    public static  void showMessage(String msg){
        System.out.println(msg);
    }


}
