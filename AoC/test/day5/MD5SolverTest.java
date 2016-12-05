package day5;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MD5SolverTest {

  @Test
  public void should_create_md5solver(){
    MD5Solver md5Solver = new MD5Solver();
  }

  @Test
  public void should_calculate_MD5_hash(){
    MD5Solver md5Solver = new MD5Solver();

    assertThat(md5Solver.MD5Hash("asdfghj"),is("c83b2d5bb1fb4d93d9d064593ed6eea2"));
    assertThat(md5Solver.MD5Hash("123456"),is("e10adc3949ba59abbe56e057f20f883e"));
    assertThat(md5Solver.MD5Hash("Jose Llorens Ripolles"),is("dadb4b1eff11d57cb65185efccff9211"));
  }

  @Test
  public void should_check_if_5_zeroes(){
    MD5Solver md5Solver = new MD5Solver();

    assertThat(md5Solver.checkIfFiveZeroes("1234567890"),is(false));
    assertThat(md5Solver.checkIfFiveZeroes("0000000000"),is(true));
    assertThat(md5Solver.checkIfFiveZeroes("0000"),is(false));
    assertThat(md5Solver.checkIfFiveZeroes("00000"),is(true));
    assertThat(md5Solver.checkIfFiveZeroes("00001"),is(false));
    assertThat(md5Solver.checkIfFiveZeroes("100001"),is(false));
  }

  @Test
  public void should_solve_part_1(){
    MD5Solver md5Solver = new MD5Solver();

    assertThat(md5Solver.solvePart1("abc"),is("18f47a30"));
    assertThat(md5Solver.solvePart1("ojvtpuvg"),is("4543c154"));
  }

  @Test
  public void should_solve_part_2(){
    MD5Solver md5Solver = new MD5Solver();

    assertThat(md5Solver.solvePart2("abc"),is("05ace8e3"));
    assertThat(md5Solver.solvePart2("ojvtpuvg"),is("1050cbbd"));
  }

  @Test
  public void should_check_if_in_bounds(){
    MD5Solver md5Solver = new MD5Solver();

    assertThat(md5Solver.checkIfInBounds('0'),is(true));
    assertThat(md5Solver.checkIfInBounds('1'),is(true));
    assertThat(md5Solver.checkIfInBounds('6'),is(true));
    assertThat(md5Solver.checkIfInBounds('7'),is(true));
    assertThat(md5Solver.checkIfInBounds('8'),is(false));
    assertThat(md5Solver.checkIfInBounds('9'),is(false));
  }


}
