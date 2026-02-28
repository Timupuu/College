import java.util.Scanner;
public class string3
{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      String input = new String();
      System.out.println("Give me a string");
      input = scanner.nextLine();
      int index;
      System.out.println("Give me an index");
      index = scanner.nextInt();
      scanner.nextLine();
      char at;
      at = input.charAt(index);
      System.out.println("The character at index " + index + " is " + at);
      char find;
      System.out.println("Give me a character to find");
      find = scanner.next().charAt(0);
      int first;
      first = input.indexOf(find);
      System.out.println("The first index of " + find + " is " + first);
      scanner.nextLine();
      String contain = new String();
      System.out.println("Give me a string to find");
      contain = scanner.nextLine();
      boolean fact;
      fact = input.contains(contain);
      System.out.println("The string " + contain + " is in the input string: " + fact);

  }
   }
