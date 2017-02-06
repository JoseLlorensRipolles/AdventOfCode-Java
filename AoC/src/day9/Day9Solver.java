package day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by JoseLlorens on 09/12/2016.
 */
public class Day9Solver {
  public int lengthDecompressed(String s){
    return deCompress(s).length();
  }

  public String deCompress(String s){
    String res = "";
    int l, n ;
    for (int i = 0; i< s.length();i++){
      if(s.charAt(i)=='('){
        int x = i+1;
        while(Character.isDigit(s.charAt(x))){
          x++;
        }
        l = Integer.parseInt(s.substring(i+1,x));
        int y = x+1;
        while(Character.isDigit(s.charAt(y))){
          y++;
        }
        n = Integer.parseInt(s.substring(x+1,y));
        for(int j = 0 ; j< n ;j++){
          res += s.substring((y+1),(y+1+l));
        }
        i = y+l;
      }else{
        res+=s.charAt(i);
      }
    }
    System.out.println(res);
    return res;
  }

  public int solvePart1(){
    String input = null;
    try {
      input = new String(Files.readAllBytes(Paths.get("src/day9/resources/input.txt")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    if(input.contains("\n")){
      System.out.println("Tiene espasios");
    }
    int solution = lengthDecompressed(input);
    System.out.println("Solution to part 1: "+solution);
    return solution;
  }
}
