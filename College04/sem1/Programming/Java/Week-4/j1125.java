import java.util.Scanner;
/**
 * Write a description of class j1125 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class j1125
{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day: ");
        String day = scanner.nextLine();
        switch(day){
        case "Sunday": System.out.println("The day is Sunday"); break;
        case "Monday": System.out.println("The day is Monday"); break;
        case "Tuesday": System.out.println("The day is Tuesday"); break;
        case "Wednasday": System.out.println("The day is Wednasday"); break;
        case "Thursday": System.out.println("The day is Thursday"); break;
        case "Friday": System.out.println("The day is Friday"); break;
        case "Saturday": System.out.println("The day is Saturday"); break;
        default: System.out.println("Invalid ");
        }
    }
}