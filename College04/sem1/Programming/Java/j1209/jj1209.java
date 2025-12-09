import java.util.Scanner;
class Student{
  int studentID;
  String name;
  int age;
}

public class jj1209{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of Students");
    int x = scanner.nextInt();
    scanner.nextLine();
    Student[] students = new Student[x];

    for(int i=0;i<x;i++){
      students[i] = new Student();
      System.out.println("Enter the ID of student ");
      students[i].studentID = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Enter the name of student ");
      students[i].name = scanner.nextLine();
      System.out.println("Enter the age of the student");
      students[i].age = scanner.nextInt();
      scanner.nextLine();
    }

  }

}
