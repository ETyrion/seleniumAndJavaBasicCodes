package javaCodes;

import java.util.Scanner;

public class factorial {
  public static void main(String []args){
    String str="";
    String rev="";
    Scanner n= new Scanner(System.in);
    str=n.next();
    int len=str.length()-1;
    for(int i=len; i>=0;i--)
    {
      rev= rev+str.charAt(i);
    }

    if(rev.equals(str))
    {
      System.out.println("It is a palindrome");
    }
    else
    {
      System.out.println("It is not a palindrome");
    }

  }


}
