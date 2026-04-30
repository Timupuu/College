import java.util.Scanner;
public class reverse {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = new String();
    System.out.println("Please enter the string");
    input = sc.nextLine();
  System.out.println("This is the reverse of the given string " + reverse(input));
  }

    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
