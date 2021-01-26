package collectionFrameworkPrac;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
  public static void main(String[] args) {
    HashMap<Integer, String> mp = new HashMap<>();
    mp.put(1, "Maths");
    mp.put(2, "English");
    mp.put(3, "Hindi");
    System.out.println(mp);
    for (Map.Entry m : mp.entrySet()) {
      System.out.println(" " + m.getKey() + " " + m.getValue());
      //mp.put(8,"Social Science");
    }

  }
}
