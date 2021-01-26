package collectionFrameworkPrac;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.testng.annotations.Test;

public class ArrayListCode {
  public static void main(String args[])
  {
//    ArrayList<String> list= new ArrayList<>();
//    list.add("Ginny");
//    list.add("Abhishek");
//    list.add("Pooja");
//    list.add("Abhishek");
//
//    Iterator<String> itr = list.iterator();
//    while(itr.hasNext())
//    {
//      System.out.println(itr.next());
 //   }
    PriorityQueue<String> queue=new PriorityQueue<String>();
    queue.add("Amit Sharma");
    queue.add("Vijay Raj");
    queue.add("JaiShankar");
    queue.add("Raj");
    System.out.println("head:"+queue.element());
    System.out.println("head:"+queue.peek());
    System.out.println("iterating the queue elements:");
    Iterator itr=queue.iterator();
    while(itr.hasNext()){
      System.out.println(itr.next());
    }
    queue.remove();
    //queue.poll();
    System.out.println("after removing two elements:");
    Iterator<String> itr2=queue.iterator();
    while(itr2.hasNext()){
      System.out.println(itr2.next());
    }
  }

  @Test
  public void arrayToList()
  {
    /*String[] arr = {"A","Z","a","B"};
    ArrayList<String> al = new ArrayList<>();
    //System.out.print(al);
    al.addAll(Arrays.asList(arr));
    al.add("Mango");
    al.add("Apple");
    System.out.print(al);
    Collections.sort(al);
    System.out.println("sorted list "+al);*/

    ArrayList<Integer> num = new ArrayList<>();
    num.add(1);
    num.add(2);
    num.add(3);
    num.add(4);
    Integer[] val = new Integer[num.size()];
    num.toArray(val);
    for(int i:val)
    {
      System.out.println(i);
    }

  }
}
