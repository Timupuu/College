import java.util.Scanner;
/**
 * Write a description of class Nov13 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nov13
{
   public static void main (String[] args){
       Scanner scanner = new Scanner(System.in);
       //Simple user input printing
       /**String add;
       System.out.println("Enter your address: ");
       add = scanner.nextLine();
       System.out.println("Your address is " + add);
       */
       // Simple printing
       /**String name = "Ram";   
       double gpa = 3.24;
       int age = 18;
       System.out.println("The name of the student is"+ name+ "his age is "+ age+"He obtained " + gpa +"gpa");
        */
       //Printing in tabular format using arrays
       
       String[] name= new String[5];
       for(int i=0;i<name.length;i++)
       {
            System.out.println("Enter the name of the student "+i);
            name[i] = scanner.nextLine();
            System.out.println(" ");
            
        }
        for(int j=0;j<name.length;j++)
       {
            System.out.print(name[j]+"\t");
               
        }
        
       //Class works
       /**System.out.println("Enter the value for digit a");
       int a = scanner.nextInt();
       System.out.println("Enter the value for digit b");
       int b = scanner.nextInt();
       
       if(a==b){
           System.out.println("a & b are equal");
       }
       else if(a!=b && a>b){
           System.out.println("a & b are not equal and a is greater than b");
       }
        else if(a!=b && a<b){
           System.out.println("a & b are not equal and a is less than b");
       }
       */
       
   }
}