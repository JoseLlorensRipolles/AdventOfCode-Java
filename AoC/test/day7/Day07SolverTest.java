package day7;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by JoseLlorens on 08/12/2016.
 */
public class Day07SolverTest {

  @Test
  public void should_check_if_ABBA(){
    Day07Solver solver = new Day07Solver();
    assertThat(solver.isABBA("abba"),is(true));
    assertThat(solver.isABBA("abcd"),is(false));
    assertThat(solver.isABBA("bddb"),is(true));
    assertThat(solver.isABBA("ioxxoj"),is(true));
    assertThat(solver.isABBA("swzexdrctfvygbhunijm"),is(false));
  }

  @Test
  public void should_parse_input(){
    Day07Solver solver = new Day07Solver();
    solver.parseInput("abba[mnop]qrst[fghdgf]adsasd[dgfyh]ghfgh");
  }

  @Test
  public void should_solve_part1() throws IOException {
    Day07Solver solver = new Day07Solver();
    System.out.println(solver.solvePart1());
  }

  @Test
  public void should_solve_part2() throws IOException {
    Day07Solver solver = new Day07Solver();
    System.out.println(solver.solvePart2());
  }

  @Test
  public void should_get_abas(){
    Day07Solver solver = new Day07Solver();

    List<String> list = new ArrayList<>();
    list.add("aba");
    list.add("xyz");
    list.add("aaa");
    list.add("asdhufiui");
    list.add("adaiuytre");

    solver.getABAs(list);
  }


}
