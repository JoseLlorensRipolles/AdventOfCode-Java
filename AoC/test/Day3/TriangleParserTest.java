package Day3;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleParserTest {

  @Test
  public void should_create_triangle_parser(){
    TriangleParser triangleParser = new TriangleParser();
  }

  @Test
  public void should_parse_input_to_triangle(){
    Triangle triangle = TriangleParser.parse("  1  2  3");
    Triangle other = new Triangle (1,2,3);
    assertThat(triangle.equals(other),is(true));
    other = new Triangle(2,2,3);
    assertThat(triangle.equals(other),is(false));

    triangle = TriangleParser.parse("  545  626  626");
    other = new Triangle(545,626,626);
    assertThat(triangle.equals(other),is(true));

    other = new Triangle(572,23,922);
    assertThat(triangle.equals(other),is(false));



  }
}
