package day6;

import java.io.*;
import java.util.*;

/**
 * Created by JoseLlorens on 06/12/2016.
 */
public class DeCorrupter {

  public String solve_part_1() throws IOException {
    BufferedReader bf = null;
    try {
      bf = new BufferedReader(new FileReader("src/day6/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    List<Map<Character,Integer>> listFrequency = new ArrayList<>(8);
    char[] solution = new char[8];

    for(int i = 0; i<8; i++){
      Map map = new Hashtable<>();
      listFrequency.add(map);
    }

    String line;
    while((line = bf.readLine())!=null){
      char[] lineChars = line.toCharArray();
      for(int i = 0; i<lineChars.length;i++){
        Map mapFrequency = listFrequency.get(i);
        if(mapFrequency.get(lineChars[i]) ==null){
          mapFrequency.put(lineChars[i],1);
        }else{
          mapFrequency.put(lineChars[i],((int)mapFrequency.get(lineChars[i])+1));
        }
        if(solution[i] == '\0' || (Integer)mapFrequency.get(lineChars[i])>(Integer)mapFrequency.get(solution[i])){
          solution[i]=lineChars[i];
        }
      }
    }
    return new String(solution);
  }

  public String solve_part_2() throws IOException {
    BufferedReader bf = null;
    try {
      bf = new BufferedReader(new FileReader("src/day6/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    List<Map<Character,Integer>> listFrequency = new ArrayList<>(8);
    char[] solution = new char[8];

    for(int i = 0; i<8; i++){
      Map map = new Hashtable<>();
      listFrequency.add(map);
    }

    String line;
    while((line = bf.readLine())!=null){
      char[] lineChars = line.toCharArray();
      for(int i = 0; i<lineChars.length;i++){
        Map mapFrequency = listFrequency.get(i);
        if(mapFrequency.get(lineChars[i]) ==null){
          mapFrequency.put(lineChars[i],1);
        }else{
          mapFrequency.put(lineChars[i],((int)mapFrequency.get(lineChars[i])+1));
        }
      }
    }

    for(int i = 0 ; i<8;i++){
      PriorityQueue<PairLetterNumber> pq = new PriorityQueue<>();
      for (char c : listFrequency.get(i).keySet()){
        pq.add(new PairLetterNumber(c,listFrequency.get(i).get(c)));
      }
      solution[i] = pq.poll().getLetter();
    }

    return new String(solution);
  }

  public static void main (String[] args){
    DeCorrupter deCorrupter = new DeCorrupter();
    try {
      System.out.println("Part 1 solution: "+deCorrupter.solve_part_1());
      System.out.println("Part 2 solution: "+deCorrupter.solve_part_2());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
