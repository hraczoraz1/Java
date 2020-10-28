/*Loop and Map.Entry Exercises
Write a program that does the following:
Asks the user for 5 numbers
Stores them in an array list
Finds the sum, product, largest, and smallest of those numbers
*/

import java.io.IOError;
import java.util.Scanner;
import java.util.scanner;
class numHomework {

    //Display menu to console
    static void menu(){
        System.out.println("##########################");
        System.out.println("##### Number Program #####");
        System.out.println("##########################");

        System.out.println("Please enter 5 numbers and we will do the following:");
        System.out.println("Find the sum");
        System.out.println("Find the product");
        System.out.println("Find the largest");
        System.out.println("Find the smallest");

    }

    //Get number from user
    //reader.nextInt ensures an integer is input or program exits
    static int getNum(int num){
        System.out.println("enter number: " + num);
        //Setup the scanner
        Scanner reader = new Scanner(System.in);
        Integer number = reader.nextInt();
        return number;
     
    }

        //Finds the sum of numbers
    public static void findSum(int[] numArray){
        int sum = 0;
        for(int i = 0; i<5; i++){
            sum += numArray[i];
        }
        System.out.println("the sum of your numbers is: " + sum);
        
    }

    //Find the product of all numbers in array
    public static void findProduct(int[] numArray){
        int product = 1;
        for(int i = 0; i<5; i++){
            product = product * numArray[i];
        }
        System.out.println("the product of your numbers is: " + product);
            
    }

    //Find the smallest number in array
    public static void findSmallest (int[] numArray){
        int smallest = numArray[0];
        for(int i = 0; i<5; i++){
            if (numArray[i]<smallest){
                smallest = numArray[i];
            }
        }

        System.out.println("the smallest numbers is: " + smallest);
            
    }

    //find the largest value in array
    public static void findLargest (int[] numArray){
        int largest = numArray[0];
        for(int i = 0; i<5; i++){
            if (numArray[i]>largest){
                largest = numArray[i];
            }
        }

        System.out.println("the largest numbers is: " + largest);
            
    }
    public static void main(String args[]){
        
       
        menu();

        //Array to hold numbers the user inputs
        int[] numArray = new int[5];

        
        //Get 5 numbers from the user
        for (int a = 1; a<6;a++){
            int returnNum = getNum(a);
            int b = a -1;
            numArray[b] = returnNum;
        }
        
        //Get sum
        findSum(numArray);
        
        //Get product
        findProduct(numArray);
        
        //Get largest
        findLargest(numArray);

        //Get smallest
        findSmallest(numArray);
    }
}