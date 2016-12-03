package Day3;

public class TriangleParser {
  public TriangleParser() {
  }

  public static Triangle parse(String s) {

    //Reduce withespaces to one in order to split it
    s = s.replaceAll(" +", " ");

    //Deleting the first whitespace in order to split it
    s = s.substring(1);

    String[] num = s.split(" ");

    return new Triangle(Integer.parseInt(num[0]),
                        Integer.parseInt(num[1]),
                        Integer.parseInt(num[2]));
  }
}
