package day7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07Solver {


  public Day07Solver() {
  }

  public boolean isABBA(String s){
    for(int i = 0; i< s.length()-3;i++){
      if(s.charAt(i) == s.charAt(i+3)&&
          s.charAt(i+1)==s.charAt(i+2)&&
          s.charAt(i+1) != s.charAt(i)){
        return true;
      }
    }
    return false;
  }

  public List<String> getABAs(List<String> list){
    List<String> abas = new ArrayList<>();
    for(String s : list){
      for(int i = 0; i< s.length()-2;i++){
        if(s.charAt(i+2)==s.charAt(i)&&
            s.charAt(i)!=s.charAt(i+1)){
          abas.add(s.substring(i,i+3));
        }
      }
    }
    return abas;
  }



  public Map<String,List<String>> parseInput(String s){


    Map<String,List<String>> parsed = new Hashtable<>();
    List<String> insideBrackets = new ArrayList<>();
    List<String> outsideBrackets = new ArrayList<>();



    String regex = "\\[(.*?)\\]";
    Pattern pattern  = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(s);

    while (matcher.find()){
      insideBrackets.add(matcher.group(1));
      s = s.replace("["+matcher.group(1)+"]",",");
    }

    String[] aux = s.split(",");
    for(String s1 : aux){
      outsideBrackets.add(s1);
    }

    parsed.put("insideBrakets",insideBrackets);
    parsed.put("outsideBrakets",outsideBrackets);
    return parsed;
  }

  public int solvePart1() throws IOException {
    BufferedReader bf = null;
    try {
      bf = new BufferedReader(new FileReader("src/day7/resources/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    String line = null;
    int count =0;
    while ((line=bf.readLine())!=null){
      if(supportsTLS(line)){
        count++;
      }
    }
    return count;
  }

  public int solvePart2() throws IOException {
    BufferedReader bf = null;
    try {
      bf = new BufferedReader(new FileReader("src/day7/resources/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    String line = null;
    int count =0;
    while ((line=bf.readLine())!=null){
      if(supportsSSL(line)){
        count++;
      }
    }
    return count;
  }

  private boolean supportsSSL(String line) {
    Map <String,List<String>> map = parseInput(line);
    List<String> abas = getABAs(map.get("outsideBrakets"));
    List<String> babs = getABAs(map.get("insideBrakets"));
    for(String aba : abas){
      for(String bab :babs){
        if(aba.charAt(0)==bab.charAt(1) &&
            aba.charAt(1)==bab.charAt(0)){
          return true;
        }
      }
    }
    return false;
  }

  public  boolean supportsTLS(String line) {
    Map<String,List<String>> map = parseInput(line);
    List<String> inside = map.get("insideBrakets");
    List<String> outside = map.get("outsideBrakets");
    for (String s : inside){
      if(isABBA(s)){
        return false;
      }
    }

    for(String s : outside){
      if(isABBA(s)){
        return true;
      }
    }

    return false;
  }
}
