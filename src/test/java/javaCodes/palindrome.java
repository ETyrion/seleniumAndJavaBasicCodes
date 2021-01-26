package javaCodes;

import org.testng.annotations.Test;

public class palindrome {
  public static void palNum(int n) {
    int temp = n;
    int rem = 0;
    int rev = 0;
    while (n > 0) {
      rem = n % 10;
      rev = rev * 10 + rem;
      System.out.println(rev);
      n = n / 10;
      System.out.println(n);
    }

    if (temp == rev) {
      System.out.println("it is palindrome");
    } else {
      System.out.println("Not");
    }
  }

  public static void strPal(String str) {
    String rev = "";
    int len = str.length();
    for (int i = len - 1; i >= 0; i--) {
      rev = rev + str.charAt(i);
    }

    if (rev.equals(str)) {
      System.out.println("Palindrome");
    } else {
      System.out.println("Not");
    }
  }

  public static void main(String[] args) {
    palNum(1211);
    strPal("MADAM");
  }

  @Test
  public static void strPal() {
    String org = "MADAM";
    String rev = "";
    int len = org.length() - 1;
    for (int i = len; i >= 0; i--) {
      rev = rev + org.charAt(i);
    }

    if (rev.equals(org)) {
      System.out.println("pal");
    } else {
      System.out.println("not pal");
    }

  }

}
