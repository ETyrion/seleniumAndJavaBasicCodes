package javaCodes;

public class functionOverloading {

  public static int sum(int a, int b)
  {
    return a+b;
  }

  public static int sum(int a, int b, int c)
  {
    return a+b+c;
  }

  public static void main(String[] args)
  {
    int c;
    c=sum(5,10);
    System.out.println(c);
    int d;
    d=sum(10,11,12);
    System.out.print(d);
  }
}
