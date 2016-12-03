package Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TriangleParser {
  public TriangleParser() {
  }

  public Triangle parse(String s) {

    //Reduce withespaces to one in order to split it
    s = s.replaceAll(" +", " ");

    //Deleting the first whitespace in order to split it
    s = s.substring(1);

    String[] num = s.split(" ");

    return new Triangle(Integer.parseInt(num[0]),
                        Integer.parseInt(num[1]),
                        Integer.parseInt(num[2]));
  }

  public List<Triangle> parseAllTrianglesVertically(Queue<String> lines){
    ArrayList<Triangle> result = new ArrayList<Triangle>();

    String s;
    String[] num;
    Queue<Integer> queue1,queue2, queue3;
    Queue<Integer> all;

    queue1 = new LinkedBlockingQueue<>(2000);
    queue2 = new LinkedBlockingQueue<>(2000);
    queue3 = new LinkedBlockingQueue<>(2000);
    all = new LinkedBlockingQueue();

    while(!lines.isEmpty()){
      s = lines.poll();

      s = s.replaceAll(" +", " ");
      s = s.substring(1);

      num = s.split(" ");
      queue1.add(Integer.parseInt(num[0]));
      queue2.add(Integer.parseInt(num[1]));
      queue3.add(Integer.parseInt(num[2]));


      all = new LinkedBlockingQueue();
      all.addAll(queue1);
      all.addAll(queue2);
      all.addAll(queue3);

    }
    Triangle triangle;
    while (!all.isEmpty()){
      triangle = new Triangle (all.poll(),all.poll(),all.poll());
      result.add(triangle);
    }
    return result;
  }
}
