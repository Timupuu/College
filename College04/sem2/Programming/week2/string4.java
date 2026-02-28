import java.util.Scanner;
public class string4
{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = new String();
    System.out.println("Give me a string");
    input = scanner.nextLine();
    String inputUp = new String();
    inputUp = input.toUpperCase();
    System.out.println("The string in uppercase is " + inputUp);
    String inputLw = new String();
    inputLw = input.toLowerCase();
    System.out.println("The string in lowercase is " + inputLw);
    String[] words = input.split(" ");
  StringBuilder titleCase = new StringBuilder();
    for (String word : words) {
      if (word.length() > 0) {
        titleCase.append(Character.toUpperCase(word.charAt(0)))
                 .append(word.substring(1).toLowerCase())
                 .append(" ");
      }
    }
  String inputTc = titleCase.toString().trim();
  System.out.println("The string in title case is " + inputTc);
  }
   }
