package Day4;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoomSolverTest {

  public RoomSolverTest() {
  }

  @Test
  public void should_create_room_solver(){
   RoomSolver roomSolver = new RoomSolver();
  }

  @Test
  public void should_chek_if_real(){
    RoomSolver roomSolver = new RoomSolver();
    String s = "aaaaa-bbbbb-ccc-dd-e-660[abc]";
    assertThat(roomSolver.isReal(s), is(true));

    s = "aaaaa-bbbbb-ccc-dd-e-660[abc]";
    assertThat(roomSolver.isReal(s), is(true));

    s = "aaaaa-bbb-z-y-x-123[abxyz]";
    assertThat(roomSolver.isReal(s), is(true));

    s = "a-b-c-d-e-f-g-h-987[abcde]";
    assertThat(roomSolver.isReal(s), is(true));

    s = "not-a-real-room-404[oarel]";
    assertThat(roomSolver.isReal(s), is(true));

    s = "totally-real-room-200[decoy]";
    assertThat(roomSolver.isReal(s), is(false));
  }

  @Test
  public void should_extract_id(){
    RoomSolver roomSolver = new RoomSolver();
    String s = "aaaaa-bbbbb-ccc-dd-e-660[abc]";
    assertThat(roomSolver.extractId(s), is(660));
  }

  @Test
  public void should_solve_part1(){
    RoomSolver roomSolver = new RoomSolver();
    assertThat(roomSolver.solve("input.txt"),is(1514));
  }
}
