
// Usage of book class & object
/**class Book{
  String title;
  String author;
  double priceOfBook;

}

public class workshop{
  public static void main(String[] args) {
    Book bk1 = new Book();
    Book bk2 = new Book();
    bk1.title = "Cheena harayeko manxe";
    bk1.author = "Hari bahadur";
    bk1.priceOfBook = 500;
    System.out.println(bk1.title + " "+ bk1.author +" "+ bk1.priceOfBook);
  }
}*/ 

// Usage of rectangle object and class 

/**class Rect{
  int breath;
  int length;
}
public class workshop{
  public static void main(String[] args) {
    Rect rt1 = new Rect();
    Rect rt2 = new Rect();
    rt1.breath = 10;
    rt1.length = 20;
    System.out.println("The dimensions of the rectangle are " + rt1.breath + " " + rt1.length + " The area of the rectangle is " + (rt1.length * rt1.breath));
  }
}*/ 

// Usage of Employee object and class

/** class Emp{
  int id;
  String name;
  double salary;
}
public class workshop{
public static void main(String[] args) {
  Emp ram = new Emp();
  ram.id = 1;
  ram.name = "ram";
  ram.salary = 200;
  Emp har = new Emp();
  har.id = 2;
  har.name = "hari";
  har.salary = 300;
  Emp raj = new Emp();
  raj.id = 3;
  raj.name = "raj";
  raj.salary = 400;
  System.out.println(ram.id + " " + ram.name + " " + ram.salary);
  if(ram.salary > har.salary){
    if(ram.salary > raj.salary){
      System.out.println("The highest salary is of " + ram.name);
    }
  }
if(raj.salary > har.salary){
    if(raj.salary > ram.salary){
      System.out.println("The highest salary is of " + raj.name);
    }
    else {
    System.out.println("The highest salary is of " + har.name);    
      }  
  }
}
}*/ 




