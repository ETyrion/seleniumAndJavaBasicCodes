package javaCodes;

public class remainderCode {
  public static void main(String[] args) {
    int n = 7;
    float q = (float) (4.5 % 2);
    ;
    int r;
    for (int i = 1; i < n / 2; i++) {
      r = n % i;
      System.out.println(r);
    }

    System.out.println(q);

  }
}
