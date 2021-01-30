package javaCodes;

import org.testng.annotations.Test;

public class ReversingWithoutAlteringSpace {
  @Test
  public void reverse() {
    String str = "ABCDE F GHI JK";
    char[] input = str.toCharArray();
    char[] rev = new char[input.length];

    for (int i = 0; i < input.length; i++) {
      if (input[i] == ' ') {
        rev[i] = ' ';
      }
    }

    int j = rev.length - 1;

    for (int i = 0; i < input.length; i++) {
      if (input[i] != ' ') {
        if (rev[j] == ' ') {
          j--;
        }
        rev[j] = input[i];
        j--;
      }
    }

    System.out.println(String.valueOf(rev));

  }

  @Test
  public void test2() {
    String str = "HE LLO WORL D";
    char[] input = str.toCharArray();
    char[] rev = new char[input.length];
    int j = input.length - 1;

    for (int i = 0; i < input.length; i++) {
      if (input[i] == ' ') {
        rev[i] = ' ';
      }
    }

    for (int i = 0; i < input.length; i++) {
      if (input[i] != ' ') {
        if (rev[j] == ' ') {
          j--;
        }

        rev[j] = input[i];
        j--;
      }
    }

    System.out.println(String.valueOf(rev));
  }
}
