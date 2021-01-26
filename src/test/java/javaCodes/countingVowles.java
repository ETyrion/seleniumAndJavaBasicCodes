package javaCodes;

public class countingVowles {
  public static int countV(String str)
  {
    int n=str.length();
    int count=0;
    String s= "";
    s=str;
    char ch[]= new char[n];
    for(int i=0;i<n;i++)
    {
      if((s.charAt(i)=='A') || (s.charAt(i)=='E'))
      {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args){
    int cnt=countV("INDIAE");
    System.out.println(cnt);
  }
}
