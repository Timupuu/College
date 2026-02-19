import java.util.Scanner;

public class string1
{
  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      String stringa = new String();
      String stringb = new String();
      String stringcom = new String();
      String stringex = new String();
      System.out.println("Give me one string");
      stringa = scanner.nextLine();
      System.out.println("Give me another string");
      stringb = scanner.nextLine();
      stringcom = stringa.concat(stringb);
      System.out.println("Here is the combined string " +  stringcom);
      
      System.out.println("Give me another string");
      stringex = scanner.nextLine();
      
      boolean same = stringex.equals(stringcom);
      System.out.println(" The fact that both strings are same is " + same);
  }
}