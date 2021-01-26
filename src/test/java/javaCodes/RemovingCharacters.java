package javaCodes;

public class RemovingCharacters {
  public static void remove(String a)
  {
    int len=a.length();
    String rev=a;
    int j=0;
    System.out.println("System.out.println: :->  "+len);

    System.out.println(a);
    for(int i=len-1; i>=len/2;i--)
    {
      System.out.println(a.substring(j,i));
      j=j+1;
      if(j<=len/2)
      {
       System.out.println(a.substring(j,i));
      }
    }
  }

  public static void main(String[] args)
  {
    remove("COMPUTER");
  }
}
/*
* PALINDROME
* PALINDROM
* ALINDROM
* ALINDRO
* LINDRO
* LINDR
* INDR
* IND
* ND
* D*/