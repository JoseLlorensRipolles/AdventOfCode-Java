package Day3;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
  @Test
  public void should_create_triangle(){
    Triangle triangle = new Triangle(1,2,3);
  }

  @Test
  public void should_check_if_possible(){
    Triangle triangle = new Triangle(5,10,25);
    assertThat(triangle.isPossible(),is(false));

    triangle = new Triangle(20,20,25);
    assertThat(triangle.isPossible(),is(true));

    triangle = new Triangle(1,2,4);
    assertThat(triangle.isPossible(),is(false));

    triangle = new Triangle(1,2,3);
    assertThat(triangle.isPossible(),is(false));
  }




}
