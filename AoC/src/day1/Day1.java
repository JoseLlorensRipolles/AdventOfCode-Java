package day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Day1 {
  public static void main(String[] args){
    Scanner kb = new Scanner(System.in).useLocale(Locale.US);
    String map = kb.nextLine();
    String[] instructions = map.split(", ");
    Point actual = new Point(0,0);
    List<Line> lines = new ArrayList<Line>();
    char facing = 'N';
    for(int i = 0 ; i<instructions.length;i++){
      char turn = instructions[i].charAt(0);
      int num = Integer.parseInt(instructions[i].substring(1));
      switch(facing){
        case 'N':
          if(turn == 'R'){
            facing = 'E';
            Point newPoint =new Point(actual.getX()+num,actual.getY());
            Line line = new Line(actual,newPoint);
            checkIfIntersects(line,lines);
            lines.add(line);
            actual = newPoint;
          }else{
            facing = 'W';
            Point newPoint =new Point(actual.getX()-num,actual.getY());
            Line line = new Line(actual,newPoint);
            checkIfIntersects(line,lines);
            lines.add(line);
            actual = newPoint;
          }
          break;
        case 'E':
          if(turn == 'R'){
            facing = 'S';
            Point newPoint =new Point(actual.getX(),actual.getY()-num);
            Line line = new Line(actual,newPoint);
            checkIfIntersects(line,lines);
            lines.add(line);
            actual = newPoint;
          }else{
            facing = 'N';
            Point newPoint =new Point(actual.getX(),actual.getY()+num);
            Line line = new Line(actual,newPoint);
            checkIfIntersects(line,lines);
            lines.add(line);
            actual = newPoint;
          }
          break;
        case 'W':
          if(turn == 'R'){
            facing = 'N';
            Point newPoint =new Point(actual.getX(),actual.getY()+num);
            Line line = new Line(actual,newPoint);
            checkIfIntersects(line,lines);
            lines.add(line);
            actual = newPoint;
          }else{
            facing = 'S';
            Point newPoint =new Point(actual.getX(),actual.getY()-num);
            Line line = new Line(actual,newPoint);
            checkIfIntersects(line,lines);
            lines.add(line);
            actual = newPoint;
          }
          break;
        case 'S':
          if(turn == 'R'){
            facing = 'W';
            Point newPoint =new Point(actual.getX()-num,actual.getY());
            Line line = new Line(actual,newPoint);
            checkIfIntersects(line,lines);
            lines.add(line);
            actual = newPoint;
          }else{
            facing ='E';
            Point newPoint =new Point(actual.getX()+num,actual.getY());
            Line line = new Line(actual,newPoint);
            checkIfIntersects(line,lines);
            lines.add(line);
            actual = newPoint;
          }
          break;
      }
    }
    System.out.println("X: "+actual.getX()+"\nY: "+actual.getY()+"\nS: "+ (Math.abs(actual.getX())+Math.abs(actual.getY())));
  }

  private static void checkIfIntersects(Line newLine,List<Line> lines) {
    for(Line line : lines){
      if(isVertical(newLine)){
        if(!isVertical(line)){
          if(Math.min(newLine.getIni().getY(),newLine.getFin().getY())<line.getFin().getY()){
            if(Math.max(newLine.getIni().getY(),newLine.getFin().getY())>line.getFin().getY()){
              if(Math.min(line.getIni().getX(),line.getFin().getX())<newLine.getFin().getX()){
                if(Math.max(line.getIni().getX(),line.getFin().getX()) >newLine.getFin().getX()){
                  System.out.println("Intersects in ("+newLine.getIni().getX()+","+line.getFin().getY()+") -> "+(Math.abs(newLine.getIni().getX())+Math.abs(line.getFin().getY())));
                }
              }
              
            }
          }
        }
      }else{
        if(isVertical(line)){
          if(Math.min(line.getIni().getY(),line.getFin().getY())<newLine.getFin().getY()){
            if(Math.max(line.getIni().getY(),line.getFin().getY())>newLine.getFin().getY()){
              if(Math.min(newLine.getIni().getX(),newLine.getFin().getX())<line.getFin().getX()){
                if(Math.max(newLine.getIni().getX(),newLine.getFin().getX()) >line.getFin().getX()){
                  System.out.println("Intersects in ("+line.getIni().getX()+","+newLine.getFin().getY()+") -> "+(Math.abs(line.getIni().getX())+Math.abs(newLine.getFin().getY())));
                }
              }

            }
          }
        }
      }
    }
  }

 

  private static boolean isVertical(Line line) {
    return line.getIni().getX() == line.getFin().getX();
  }
}
