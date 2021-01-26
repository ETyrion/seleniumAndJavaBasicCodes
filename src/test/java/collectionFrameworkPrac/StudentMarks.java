package collectionFrameworkPrac;

public class StudentMarks {
  int maths;
  int english;
  int science;
  String name;
  int total;
  float per;

  public void getMarks(int m, int e, int s, String n) {
    maths = m;
    english = e;
    science = s;
    name = n;
  }

  public int totalMarks() {
    total = maths + english + science;
    return total;
  }

  public float perc()
  {
    per = total/3;
    return per;
  }

  public void displayResults()
  {
    System.out.println(name);
    System.out.println(per);
    System.out.println(total);
  }

  public static void main(String[] args){
    StudentMarks st = new StudentMarks();
    st.getMarks(90, 80, 30, "Ravi");
    int sum= st.totalMarks();
    float avg= st.perc();
    st.displayResults();
    st.getMarks(75, 65, 55, "Mohit");
    st.totalMarks();
    st.perc();
    st.displayResults();
  }
}
