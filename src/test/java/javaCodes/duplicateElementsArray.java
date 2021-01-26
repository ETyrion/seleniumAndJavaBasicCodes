package javaCodes;

public class duplicateElementsArray {

  public void duplicateRemove(int[] arr) {
    /*for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          System.out.println(arr[j]);
        }
      }

    }*/
    int n=arr.length;

    //removing the duplicate elements
    int[] temp = new int[n];
    int j = 0;
    for (int i = 0; i <n-1; i++) {
      if (arr[i] != arr[i + 1]) {
        temp[j++] = arr[i];
      }
    }
    temp[j++]= arr[n-1];

    for (int i = 0; i <j; i++)
    {
      arr[i]=temp[i];
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args)
  {
    duplicateElementsArray obj= new duplicateElementsArray();
    int a[] = {1,1,2,3,3,4,4};
    obj.duplicateRemove(a);
  }
}
