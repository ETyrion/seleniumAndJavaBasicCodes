package collectionFrameworkPrac;

import java.util.ArrayList;
import java.util.Iterator;

class studentData {
  int totalMarks;
  String name;
  int rollno;

  studentData(int totalMarks, String name, int rno) {
    this.totalMarks = totalMarks;
    this.name = name;
    this.rollno = rno;
  }
}

class teacherData {
  String tName;
  String sub;

  teacherData(String name, String sub)
  {
    this.tName= name;
    this.sub= sub;
  }
}

public class UserDefinedArrayList {

  public static  void main(String[] args) {
    studentData s1 = new studentData(100, "Gaurav", 1);
    studentData s2= new studentData(98, "Abhishek", 2);
    studentData s3= new studentData(100, "Vikrant", 3);
    teacherData td = new teacherData("Saul ","Science");
    ArrayList<studentData> val = new ArrayList<>();
    ArrayList<teacherData> val2 = new ArrayList<>();
    val.add(s1);
    val.add(s2);
    val.add(s3);
    val2.add(td);

    Iterator<studentData> itr = val.iterator();
    while(itr.hasNext())
    {
      studentData st = (studentData)itr.next();
      System.out.println(st.rollno);
      System.out.println(st.name);
      System.out.println(st.totalMarks);
      System.out.println();
    }

  }

}
