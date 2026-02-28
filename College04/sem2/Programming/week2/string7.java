import java.util.Scanner;
public class string7{
public static boolean isvalidphone(String phone)
{
    return phone.matches("^(98|97)\\d{8}$");
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = new String();
    System.out.println("Give me a phone number");
    input = scanner.nextLine();
    System.out.println("The phone number is valid: " + isvalidphone(input));
}}
