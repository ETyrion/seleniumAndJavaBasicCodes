package javaCodes;

public class childClass extends parentClass {
  childClass()
  {
    System.out.println("Base class constructor");
  }

  public void sound() {
         System.out.println("Sound of child class");
  }

  public void shape()
  {
    System.out.println("Child is round");
  }

  public void callMethods()
  {
    super.shape();
    super.sound();
  }


  public static void main(String[] args)
  {
    childClass c= new childClass();
    c.sound();
    c.shape();
    c.pro();
    c.callMethods();

    parentClass d =new parentClass();
    d.sound();

    parentClass e = new childClass();
    e.sound();
    e.shape();

  }
}
