package collectionFrameworkPrac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.testng.annotations.Test;

public class LinkedListTest {
  @Test
  public void insertEle() {
    LinkedList<Integer> ele = new LinkedList<>();
    ele.add(1);
    ele.add(2);
    ele.add(3);
    ele.add(4);
    ele.add(1);
    ele.add(2);
    System.out.println(ele);
    ele.remove(2);
    System.out.println(ele);
  }
}
