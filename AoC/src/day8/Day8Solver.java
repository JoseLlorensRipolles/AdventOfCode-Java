package day8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8Solver {
  public Screen solvePart1() throws IOException {
    Screen screen = new Screen(6,50);
    BufferedReader bf = null;
    try {
      bf = new BufferedReader(new FileReader("src/day8/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    String line = null;

    while ((line = bf.readLine())!=null){
      if(line.startsWith("rect")){
        callLitMethod(screen,line);
      }else{
        if(line.contains("row")){
          callRotateRowMethod(screen,line);
        }else{
          callRotateColumnMethod(screen,line);
        }
      }
    }
    System.out.println("Part 1 solution: "+screen.countLit());
    return screen;
  }

  public void callRotateColumnMethod(Screen screen, String line) {
    String regex = ".* column x=(\\d+) by (\\d)$";
    Pattern pattern  = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(line);

    matcher.find();
    int column =Integer.parseInt(matcher.group(1));
    int by =Integer.parseInt(matcher.group(2));
    screen.rotateColumn(column,by);
  }

  public void callRotateRowMethod(Screen screen, String line) {
    String regex = ".* row y=(\\d+) by (\\d+)$";
    Pattern pattern  = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(line);

    matcher.find();
    int row =Integer.parseInt(matcher.group(1));
    int by =Integer.parseInt(matcher.group(2));
    screen.rotateRow(row,by);
  }

  public void callLitMethod(Screen screen, String line) {
    String regex = "^rect (\\d+)x(\\d+)$";
    Pattern pattern  = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(line);

    matcher.find();
    screen.litCornerBy(Integer.parseInt(matcher.group(1)),Integer.parseInt(matcher.group(2)));
  }


  public void solvePart2() throws IOException {
    this.solvePart1().show();

  }
}
