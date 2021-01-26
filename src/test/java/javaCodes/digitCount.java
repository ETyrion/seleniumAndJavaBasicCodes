package javaCodes;

public class digitCount {

  public static void digCount(int n) {
    int q = n;
    int num=n;
    int even = 0;
    int odd = 0;
    int rem = 0;
    int z=0;
    int e=0;
    while (n!= 0) {
      q = n%10;
      System.out.println(q);
      n=n/10;

      if(q==0)
      {
     continue;
      }

      if (q % 2 == 0) {
        even++;
      } else  {
        odd++;
      }
    }
    //e= even-z;
    System.out.println("Even digits are " + e);
    System.out.println("Odd digits are " + odd);
  }

  public static void main(String[] args)
  {
    digCount(10010);
  }
}
