package Day3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleParserTest {

  @Test
  public void should_create_triangle_parser(){
    TriangleParser triangleParser = new TriangleParser();
  }

  @Test
  public void should_parse_input_to_triangle(){
    TriangleParser triangleParser = new TriangleParser();

    Triangle triangle = triangleParser.parse("  1  2  3");
    Triangle other = new Triangle (1,2,3);
    assertThat(triangle.equals(other),is(true));
    other = new Triangle(2,2,3);
    assertThat(triangle.equals(other),is(false));

    triangle = triangleParser.parse("  545  626  626");
    other = new Triangle(545,626,626);
    assertThat(triangle.equals(other),is(true));

    other = new Triangle(572,23,922);
    assertThat(triangle.equals(other),is(false));
  }

  @Test
  public void should_parse_lines_to_triangles(){
    Queue<String> queue = new LinkedBlockingQueue<>();
    TriangleParser parser = new TriangleParser();


    queue.add("  810  679   10");
    queue.add("  783  255  616");
    queue.add("  545  626  626");
    queue.add("   84  910  149");

    List<Triangle> list = parser.parseAllTrianglesVertically(queue);
    System.out.println("");

  }
}
