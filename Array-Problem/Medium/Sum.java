import java.util.*;
public class Sum{
  
   public static int sum(int num1, int num2){
     return num1+num2;
   }

   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.println("Input first number: ");
      int num1 = sc.nextInt();
      System.out.println("Input second number: ");
      int num2 = sc.nextInt();
      System.out.println("Sum of two number is "+ sum(num1, num2));
   }
}