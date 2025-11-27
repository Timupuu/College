import java.util.Scanner;
/**
 * Write a description of class j1127 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class j1127
{
    public static void main (String[] args){
    Scanner scanner = new Scanner(System.in);
    //Voting
    /**System.out.println("Enter your age: ");
    int age = scanner.nextInt();
    String result = (age>=18)? "You are eligible for citizenship":"You are not eligible for citizenship";
    System.out.println(result);
    */
    // Pass or fail
    /**System.out.println("Enter your grade: ");
    double age = scanner.nextDouble();
    String result = (age>=40)? "You have passed":"You have failed";
    System.out.println(result);
    */
    //Even odd
    /**System.out.println("Enter your number: ");
    int num = scanner.nextInt();
    String result = (num%2==0)? "This number is even":"The number is odd";
    System.out.println(result);
    */

    //Positive Negative or zero
    /**System.out.println("Enter your number: ");
    int num = scanner.nextInt();
    if(num==0){
    System.out.println("The number is zero");
    }
    else if(num>0){
    System.out.println("The number is positive");
    }
    else if(num<0){
    System.out.println("The number is negative");
    }
    */
   
    //Divisible
    /**System.out.println("Enter your number: ");
    int num = scanner.nextInt();
    if(num%3==0 && num%5==0){
    System.out.println("The number is divisible by both 3 & 5");
    }
    else if (num%3==0){
    System.out.println("The number is divisible by 3");
    }
    else if (num%5==0){
    System.out.println("The number is divisible by 5");
    }
    else {
    System.out.println("The number is invalid");
    }
    */
   
    //Nested if
    /**System.out.println("Enter your number: ");
    int num = scanner.nextInt();
    if(num%3==0 || num%5==0)
    {
        if(num%3==0 && num%5==0)
        {
            System.out.println("The number is divisible by both");
        }
        else if(num%3==0)
        {
            System.out.println("The number is divisible by 3");
        }
        else if(num%5==0)
        {
            System.out.println("The number is divisible by 5");
        }
    }
    */
    System.out.println("Enter your price: ");
    double price = scanner.nextDouble();
    System.out.println("Enter the category: ");
    char cat = scanner.next().charAt(0);
    if(cat == 'a' || cat == 'A'){
        double sp = price - (price*0.6);
        System.out.println("The selling price of that product of category "+ cat+ " is "+ sp);
    }
    else if(cat == 'b' || cat == 'B'){
        double sp = price - (price*0.4);
        System.out.println("The selling price of that product of category "+ cat+ " is "+ sp);
    }
    else if(cat == 'c' || cat == 'C'){
        double sp = price - (price*0.2);
        System.out.println("The selling price of that product of category "+ cat+ " is "+ sp);
    }
    else if(cat == 'd' || cat == 'D'){
        double sp = price - (price*0.1);
        System.out.println("The selling price of that product of category "+ cat+ " is "+ sp);
    }
    else{
    System.out.println("Invalid");
    }
    }
}