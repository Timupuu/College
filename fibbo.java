public class fibbo {
  public static void main(String[] args) {
  fibb(5) ;
  }
  public static int fibb(int n) {
  //F(n) = F(n-1) + F(n-2)
  if(n==0){
    return 0;
  }
  if(n==1){
    return 1;
  }
  return fibb(n-1) + fibb(n-2);
  }
}
