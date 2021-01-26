package javaCodes;

import java.util.Scanner;

public class Parenthesis {
  public static void main(String[] args)
  {
    int lcount=0;
    int rcount=0;
    int balFactor=0;
    String str;
    Scanner scan = new Scanner(System.in);
    str= scan.next();
    for(int i=0; i<str.length(); i++)
    {
      if(str.charAt(i)=='(')
      {
        lcount++;
      }
      else if(str.charAt(i)==')')
      {
        rcount++;
      }
    }
    balFactor=rcount-lcount;
    System.out.print(balFactor);
  }
}
