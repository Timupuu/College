public class parrot extends birds {
  void nature(){
    System.out.println("Mimicks other noises");
  }
  public static void main(String[] args) {
   parrot obj = new parrot();
   obj.fly();
   obj.eat();
   obj.nature();

  }
}
