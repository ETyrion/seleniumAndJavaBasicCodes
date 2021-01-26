package collectionFrameworkPrac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.testng.annotations.Test;

public class RemovingDuplicates {
  @Test
  public static void removeDup() {
    int sum = 0;
    ArrayList<Integer> org = new ArrayList<Integer>();
    ArrayList<Integer> temp = new ArrayList<Integer>();
    org.add(1);
    org.add(2);
    org.add(1);
    org.add(2);
    org.add(3);
    org.add(4);
    org.add(1);
    //org.sort(Comparator.naturalOrder());
    System.out.println(org);
    Iterator<Integer> itr = org.iterator();
    while (itr.hasNext()) {
      sum = sum + itr.next();
      System.out.println(sum);
    }
    HashSet<Integer> hs = new HashSet<Integer>();
    hs.addAll(org);
    System.out.println(hs);
    org.clear();
    org.addAll(hs);
    System.out.println(org);
  }

  @Test
  public void stringRemove() {
    ArrayList<String> str = new ArrayList<String>();
    str.add("A");
    str.add("B");
    str.add("A");
    str.add("C");
    str.add("B");
    System.out.println(str);

    HashSet<String> hs = new HashSet<String>();
    hs.addAll(str);
    System.out.println(hs);
    hs.add("A");
    hs.add("A");
    hs.add("Z");
    System.out.println(hs);
    str.clear();
    str.addAll(hs);
    System.out.println(str);
  }

  @Test
  public void duplicateArray() {
    int a[] = {20, 20, 21, 21, 24, 18, 18, 30};
    int temp = 0;
    int sum = 0;
    HashSet<Integer> hs = new HashSet<Integer>();
    for (int j : a) {
      temp = j;
      hs.add(temp);
    }
    System.out.println(hs);
    ArrayList<Integer> arr = new ArrayList<Integer>(hs);
    System.out.println(arr);
    for (int u : arr) {
      sum = sum + u;
      System.out.println(sum);
    }
  }

  @Test
  public static void stringRemoveFunc() {
    String org[] = {"M", "O", "A", "M", "B", "O", "C", "C"};
    ArrayList<String> str = new ArrayList<String>();
    String temp;
    for (int i = 0; i < org.length; i++) {
      temp = org[i];
      str.add(temp);
    }
    System.out.println(str);
    HashSet<String> hs = new HashSet<String>(str);
    System.out.println(hs);
  }

  @Test
  public static void pal() {
    String org = "MADAM";
    String rev = "";
    int len = org.length();
    for (int i = len - 1; i >= 0; i--) {
      rev = rev + org.charAt(i);
    }
    if (rev.equals(org)) {
      System.out.println("Palindrome");
    } else {
      System.out.println("not a pal");
    }
  }

  @Test
  public void hashRemoveDuplicate() {
    ArrayList<String> str = new ArrayList<String>();
    str.add("A");
    str.add("Z");
    str.add("A");
    str.add("Z");
    str.add("B");
    HashSet<String> hs = new HashSet<String>();
    hs.addAll(str);
    System.out.println(hs);
  }
}
