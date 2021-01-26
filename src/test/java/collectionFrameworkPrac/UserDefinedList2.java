package collectionFrameworkPrac;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

class animals
{
  String name;
  String country;
  animals(String name, String country)
  {
    this.name=name;
    this.country=country;
  }
}


public class UserDefinedList2 {
  @Test
  public void listTest()
  {
    animals rec = new animals("Tiger", "India");
    animals rec1 = new animals ("Eagle", "Saudi");
    ArrayList<animals> al= new ArrayList<>();
    al.add(rec);
    al.add(rec1);
    Iterator<animals> itr = al.iterator();
    while(itr.hasNext())
    {
      animals val = (animals) itr.next();
      System.out.println(val.country);
      System.out.println(val.name);
    }

  }
}
