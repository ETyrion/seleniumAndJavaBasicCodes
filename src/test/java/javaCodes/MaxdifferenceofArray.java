package javaCodes;

public class MaxdifferenceofArray {
  public static void maxDiff(int a[])
  {
    int max=0;
    int min=0;
    int diff=0;
    int temp=0;
    int len=a.length;
    for(int i=0; i<a.length; i++)
    {
      for(int j=i+1; j<a.length; j++)
      {
        if(a[i]>a[j])
        {
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
      System.out.print(" "+ a[i]+" ");
    }
    max=a[len-1];
    min=a[0];
    diff=max-min;
    System.out.println(diff);
  }

  public static void main(String[] args)
  {
    int[] arr= {10, 7, 2, 5, 1};
    maxDiff(arr);
  }
}
