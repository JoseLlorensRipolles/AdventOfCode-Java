package day9;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by JoseLlorens on 06/02/2017.
 */
public class Day9Part2SolverTest {
  @Test
  public void should_create_day9solver(){
    Day9Part2Solver solver = new Day9Part2Solver();
  }

  @Test
  public void should_count_leght_decomressed() {
    Day9Part2Solver solver = new Day9Part2Solver();

    assertThat(solver.lengthDecompressed("(3x3)XYZ"), is(9));
    assertThat(solver.lengthDecompressed("X(8x2)(3x3)ABCY"), is(20));
    assertThat(solver.lengthDecompressed("(27x12)(20x12)(13x14)(7x10)(1x12)A"), is(241920));
    assertThat(solver.lengthDecompressed("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"), is(445));
  }

  @Test
  public void should_solve_part_1(){
    Day9Part2Solver solver = new Day9Part2Solver();

    //assert(solver.solvePart2(), 11107527530 );
  }
}
