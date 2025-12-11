import java.util.Scanner;

public class jj1211{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
   /**  System.out.println("Enter the size of the array: ");
        int x = scanner.nextInt();
    int sum = 0;
    int[] arr = new int[x];
    for (int i = 0; i < x; i++) {
      System.out.println("Enter the value of number " + (i+1));
      arr[i] = scanner.nextInt();
      sum += arr[i];}
    int avg = sum/x;
    System.out.println("The average of the numbers in the array is: "+avg);
    */ 
    
    // 2D array
    int[][] arr = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.println("Enter the value of " + (i+1) +"row's " + (j+1)+"column");
        arr[i][j] = scanner.nextInt();
      }
    }  
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    
  }
  
}
    
  
  

