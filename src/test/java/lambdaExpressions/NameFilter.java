package lambdaExpressions;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class NameFilter {
  @Test
  public void streaamFilter()
  {
    ArrayList<String> names = new ArrayList<>();
    names.add("Virat");
    names.add("Abhi");
    names.add("Saurav");
    names.add("Sachin");
    names.add("Vinod");

    Long c= names.stream().filter(s-> s.startsWith("S")).count();
    System.out.println(c);

    Stream.of("harry", "ron", "tom riddle", "peter").map(s->s.toUpperCase()).forEach(s->System.out.println(s));

  }
}
