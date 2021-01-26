package javaCodes;

import java.util.Scanner;

public class primeNumber {

  public void primeCheck(int n)
  {
    int num;
    num = n;
    int flag=1;

    if(n<=1)
    {
      flag=0;
    }

    else if(n==2 || n==3)
    {
      flag=1;
    }

    for(int i=2; i<=num/2; i++)
    {
      if(n%i==0)
      {
        flag=0;
        break;
      }
    }

    if (flag==0)
    {
      System.out.println("number is not prime");
    }

    else {
      System.out.println("number is prime");
    }
  }

  public static void main(String [] args)
  {
    int n;
    System.out.println("Provide the number");
    Scanner s =new Scanner(System.in);
    n = s.nextInt();
    primeNumber prm = new primeNumber();
    prm.primeCheck(n);
    s.close();

  }
}
