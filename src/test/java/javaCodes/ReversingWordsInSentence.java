package javaCodes;

import org.testng.annotations.Test;

public class ReversingWordsInSentence {

  @Test
  public void rev()
  {
    String str= "My name is RAVI";
    String[] arr= str.split(" ");
    for(int i=arr.length-1; i>=0; i--)
    {
      System.out.print(arr[i]+" ");
    }

  }
}
