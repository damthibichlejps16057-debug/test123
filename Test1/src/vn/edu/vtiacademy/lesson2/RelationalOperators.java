package vn.edu.vtiacademy.lesson2;

import java.util.Scanner;

public class RelationalOperators {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); //Create a Scanner object to read input from console
    System.out.println("Enter the first number: ");
    int a = scanner.nextInt(); //Read an integer from consolde and store it in variable a
    System.out.println("Enter the second number: ");
    int b = scanner.nextInt();
    // Greater than
    System.out.println( " a > b = " + a + " > " + b + " = " + (a > b));

    // Less than
    System.out.println(" a < b = " + a + " < " + b + " = " + (a < b));

    // Greater than or equal to
    System.out.println(" a >= b = " + a + " >= " + b + " = " + (a >= b));

    //  Less than or equal to
    System.out.println(" a <= b = " + a + " <= " + b + " = " + (a <= b));

    // Equal to
    System.out.println(" a == b = " + a + " == " + b + " = " + (a == b));

    // Not equal to
    System.out.println(" a != b = " + a + " != " + b + " = " + (a != b));



  }


}
