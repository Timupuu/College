import java.util.Scanner;

public class string6b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to reverse:");
        String input = scanner.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed string: " + reversed);

        boolean isPalindrome = input.equals(new StringBuilder(input).reverse().toString());
        System.out.println("Is the string a palindrome? " + isPalindrome);

    }
}

