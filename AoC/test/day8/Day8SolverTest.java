package day8;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Day8SolverTest {

  @Test
  public void should_create_solver(){
    Day8Solver solver = new Day8Solver();
    Screen screen = new Screen(3,7);
    solver.callLitMethod(screen,"rect 3x2");
    assertThat(screen.getScreen(),is("###....\n" +
                                     "###....\n" +
                                     ".......\n"));
  }

  @Test
  public void should_parse_rotate_row(){
    Day8Solver solver = new Day8Solver();
    Screen screen = new Screen(3,7);
    screen.litCornerBy(3,2);
    solver.callRotateRowMethod(screen,"rotate row y=0 by 1");
    assertThat(screen.getScreen(),is(".###...\n" +
                                     "###....\n" +
                                     ".......\n"));
  }

  @Test
  public void should_parse_rotate_column(){
    Day8Solver solver = new Day8Solver();
    Screen screen = new Screen(3,7);
    screen.litCornerBy(3,2);
    solver.callRotateColumnMethod(screen,"rotate column x=0 by 1");
    assertThat(screen.getScreen(),is(".##....\n" +
        "###....\n" +
        "#......\n"));
  }

  @Test
  public void should_solve_part1() throws IOException {
    Day8Solver solver = new Day8Solver();
    assertThat(solver.solvePart1().countLit(),is(119));

  }

  @Test
  public void should_solve_part2() throws IOException {
    Day8Solver solver = new Day8Solver();
    solver.solvePart2();
  }
}
