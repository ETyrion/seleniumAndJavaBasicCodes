package javaCodes;

import java.util.Scanner;

public class PrintingPattern {
  public static void pattern(int n)
  {
    for(int i=0; i<n; i++)
    {
      System.out.print("*");
    }
    System.out.println("");
    for(int k=0;k<n-2; k++)
    {
      System.out.print("*");
      for(int u=1;u<n-1;u++)
      {
        System.out.print(" ");
      }
      System.out.print("*");
      System.out.println("");
    }
    for(int j=0; j<n; j++)
    {
      System.out.print("*");
    }
  }
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Provide the number of pattern");
    int a=scan.nextInt();
    pattern(a);

  }
}
