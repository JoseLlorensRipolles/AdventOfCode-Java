package Day3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Day3Part2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    TriangleParser parser = new TriangleParser();
    int count =0 ;
    Queue<String> lines = new LinkedBlockingQueue<>();

    System.out.println("Insert your input here: (After pasting it press enter, any letter and enter again)");
    while (in.hasNext("\\d+")) {
      lines.add(in.nextLine());
    }

    List<Triangle> triangles = parser.parseAllTrianglesVertically(lines);
    for(Triangle triangle: triangles){
      if(triangle.isPossible()) count++;
    }

    System.out.println("Triangulos posibles: "+count);
  }
}
