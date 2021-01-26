package javaCodes;

import org.testng.annotations.Test;

public class linearSort {
  public static void main(String arga[]) {
    int temp=0;
    int arr[] = {1,0,1,0,0,0,1,1,1,0,0,1};
    int len= arr.length;
    for(int i=0; i<len;i++)
    {
      for(int j=i+1; j<len;j++) {
        if (arr[i] < arr[j]) {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }

    for(int i=0; i<len;i++)
    {
      System.out.print(" "+arr[i]);
    }
  }

 /* @Test
  public void lin()
  {
    int[] ar= {1,4,1,10,0,9,1,1,6,0,0,1};
    int temp;

    for(int i=0; i<ar.length; i++)
    {
      for(int j=i+1; j<ar.length; j++)
      {
        if(ar[i]>ar[j])
        {
          temp=ar[i];
          ar[i]=ar[j];
          ar[j]= temp;
        }
      }
    }

    for(int k=0; k<ar.length; k++)
    {
      System.out.print(ar[k]+", ");
    }
  }*/
}
