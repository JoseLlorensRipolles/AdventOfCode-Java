package day9;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by JoseLlorens on 09/12/2016.
 */
public class Day9SolverTest {

  @Test
  public void should_create_day9solver(){
    Day9Solver solver = new Day9Solver();
  }

  @Test
  public void should_count_leght_decomressed(){
    Day9Solver solver = new Day9Solver();

    assertThat(solver.lengthDecompressed("A(1x5)BC"),is(7));
    assertThat(solver.lengthDecompressed("(3x33)XYZ"),is(99));
    assertThat(solver.lengthDecompressed("ADVENT"),is(6));

    assertThat(solver.lengthDecompressed("A(2x2)BCD(2x2)EFG"),is(11));
    assertThat(solver.lengthDecompressed("(6x1)(1x3)A"),is(6));
    assertThat(solver.lengthDecompressed("X(8x2)(3x3)ABCY"),is(18));
    assertThat(solver.lengthDecompressed("(3x3)XYZ(2x2)BCD(2x2)EFG(6x1)(1x3)AX(8x2)(3x3)ABCY"),is(43));
    assertThat(solver.lengthDecompressed("ADVENT"),is(6));
  }

  @Test
  public void should_solve_part_1(){
    Day9Solver solver = new Day9Solver();

    assertThat(solver.solvePart1(),is(300));
  }
}
