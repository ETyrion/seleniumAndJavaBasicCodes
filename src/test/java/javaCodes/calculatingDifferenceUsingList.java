package javaCodes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class calculatingDifferenceUsingList {

  public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here

    int diff=0;
    int sumd1=0;
    int sumd2=0;

    for(int i=0; i<arr.size(); i++)
    {
      sumd1 = sumd1+arr.get(i).get(i);
      sumd2= sumd2+arr.get(i).get(arr.size()-(i+1));

    }

    diff = Math.abs(sumd1-sumd2);
    return diff;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      List<Integer> arrRowItems = new ArrayList<>();

      for (int j = 0; j < n; j++) {
        int arrItem = Integer.parseInt(arrRowTempItems[j]);
        arrRowItems.add(arrItem);
      }

      arr.add(arrRowItems);
    }

    int result = calculatingDifferenceUsingList.diagonalDifference(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
