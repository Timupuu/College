import java.util.Scanner;
public class string5
{
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    StringBuilder input = new StringBuilder("");
    System.out.println("Give me a string");
    input.append(scanner.nextLine());
    String second = new String();
    System.out.println("Give me a second string");
    input.append(scanner.nextLine());
    int app;
    System.out.println("Give me an int to append");
    input.append(scanner.nextInt());
    char apps;
    System.out.println("Give me a char to append");
    input.append(scanner.next().charAt(0));
    System.out.println("The final string is " + input.toString());
    }
}
