package javaCodes;

public class Recursion {
  public static int fact(int n)
  {
    if(n==1)
    {
      return 1;
    }
    else
    {
      return(n*fact(n-1));
    }
  }

  public static void main(String[] args)
  {
    int result = fact(5);
    System.out.println(result);
  }
}
