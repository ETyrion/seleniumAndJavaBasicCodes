package collectionFrameworkPrac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class HashSetTest {

  @Test
  public void useHash()
  {
    /*int[] arr= {1,1,1,5,5,3,3,4,4,8,9,8};
    ArrayList<Integer> li= new ArrayList<>();
    int temp=0;
    for(int i:arr)
    {
      temp=arr[i];
      li.add(temp);
    }
    System.out.println(li);
    HashSet<Integer> hs= new HashSet<>();
    hs.addAll(li);
    hs.add(9);
    hs.remove(4);
    System.out.println(hs);*/
    HashMap<Integer, String> mp = new HashMap<>();
    mp.put(1,"Abhishek");
    mp.put(2,"Saumya");
    mp.put(3, "Ajit");
    for(Map.Entry m: mp.entrySet())
    {
      System.out.println(m.getKey() +" "+ m.getValue());
    }
  }
}
