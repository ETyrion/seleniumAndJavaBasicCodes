package javaCodes;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.annotations.Test;

public class ReverseArray {
  @Test
  public static void rev()
  {
    int[] a= {1,2,3,4,4,5};
    int temp;
    /*int[] rev= new int[a.length];
    int j=0;
    for(int i=a.length-1; i>=0; i--)
    {
      rev[j]=a[i];
      j++;
    }

    for(int k=0; k<rev.length; k++)
    {
      System.out.println(rev[k]);
    }*/
    ArrayList<Integer> org= new ArrayList<>();
    for(int i=0; i< a.length; i++)
    {
      temp = a[i];
      org.add(temp);
    }
    Collections.reverse(org);
    System.out.println(org);

  }
}
