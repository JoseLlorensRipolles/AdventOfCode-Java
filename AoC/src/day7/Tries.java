package day7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JoseLlorens on 08/12/2016.
 */
public class Tries {
  public static void main(String[] args){
    String s = "abba[mnop]qrst[asdf]";

    String regex = "\\](.*)\\[";
    Pattern pattern  = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(s);

    while (matcher.find()){
      System.out.println(matcher.group(1));
    }
  }
}
