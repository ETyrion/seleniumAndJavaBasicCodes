package newPractice;

public class CountChar {

  public static void countCharacters(String str, char c) {
    int count = 0;
    int length = str.length();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == c) {
        count++;
      }
    }
    System.out.println("Count of " + c + " is " + count);
  }

  public static void main(String[] args) {
    countCharacters("", 'a');
  }
}

