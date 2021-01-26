package javaCodes;

public class revarr {
  public static void main(String[] args){
    int arr[]={1,2,3,4};
    //int rev[]= new int[4];
    int temp=0;
    int size= arr.length-1;
    for(int i=0; i<=size/2;i++)
    {
      temp= arr[i];
      arr[i]=arr[size-i];
      arr[size-i]=temp;
    }

    for(int k=0; k<arr.length;k++)
    {
      System.out.print(" "+arr[k]);
    }
  }
}
