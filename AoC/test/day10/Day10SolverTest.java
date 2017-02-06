package day10;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by JoseLlorens on 06/02/2017.
 */
public class Day10SolverTest {
  @Test
  public void should_create_solver(){
    Day10Solver solver = new Day10Solver();
  }

  @Test
  public void should_solve_test_input() throws IOException {
    Day10Solver solver = new Day10Solver();
    solver.solvePart1();
  }
}
