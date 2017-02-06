package day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by JoseLlorens on 06/02/2017.
 */
public class Day9Part2Solver {
  public long solvePart2() {
    String input = null;
    try {
      input = new String(Files.readAllBytes(Paths.get("src/day9/resources/input.txt")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (input.contains("\n")) {
      System.out.println("Tiene espasios");
    }
    long solution = lengthDecompressed(input);
    System.out.println("Solution to part 1: " + solution);
    return solution;
  }

  public long lengthDecompressed(String s) {
    long count = 0;
    int x,l,y,n;
    for(int i = 0; i< s.length(); i++){
      if(s.charAt(i) == '('){
        x = i+1;
        while(Character.isDigit(s.charAt(x))){
          x++;
        }
        l = Integer.parseInt(s.substring(i+1,x));
        y = x+1;
        while(Character.isDigit(s.charAt(y))){
          y++;
        }
        n = Integer.parseInt(s.substring(x+1,y));
        count += lengthDecompressed(s.substring(y+1,y+l+1))*n;
        i = y+l;
      }else{
        count++;
      }
    }
    return count;
  }
}
