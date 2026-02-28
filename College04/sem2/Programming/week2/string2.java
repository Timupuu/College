import java.util.Scanner;

public class string2{
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    String stringa = new String();
    String stringt = new String();
    String strings = new String();
    String stringsp[] = new String[10];
    
    System.out.println("Give me a string");
    stringa = scanner.nextLine();
    stringt = stringa.trim();
    strings = stringa.substring(0,9);
    stringsp = stringa.split(" ");
    
    System.out.println("The initial string was " + stringa);
    System.out.println("The trimmed string is " + stringt);
    System.out.println("The substring is " + strings);
    for (int i = 0; i<stringsp.length;i++){
        System.out.println(stringsp[i]+"\n");
    }
}
}
