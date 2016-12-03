package Day3;

import java.util.Scanner;

public class Day3 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int count = 0;
    TriangleParser triangleParser = new TriangleParser();
    Boolean salir = false;
    while(in.hasNextLine()&&!salir){
      String line = in.nextLine();
      if(line.equals("")){
        salir = true;
      }else {
        if (triangleParser.parse(line).isPossible()) {
          count++;
        }
      }
    }

    System.out.println("Number of possible triangles: "+count);
  }
}
