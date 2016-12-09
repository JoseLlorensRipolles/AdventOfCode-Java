package day8;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ScreenTest {

  @Test
  public void should_create_screen(){
    Screen screen = new Screen(3,7);
  }

  @Test
  public void should_get_scren(){
    Screen screen = new Screen(3,7);
    assertThat(screen.getScreen(),is(".......\n" +
                                     ".......\n" +
                                     ".......\n"));
  }

  @Test
  public void should_lit_corner_by_XxY(){
    Screen screen = new Screen(3,7);
    screen.litCornerBy(3, 2);
    assertThat(screen.getScreen(),is("###....\n" +
                                      "###....\n" +
                                      ".......\n"));
  }

  @Test
  public void should_rotate_column(){
    Screen screen = new Screen(3,7);
    screen.litCornerBy(3,2);
    screen.rotateColumn(1,1);
    assertThat(screen.getScreen(),is("#.#....\n" +
                                     "###....\n" +
                                     ".#.....\n"));
    screen.rotateColumn(2,2);
    assertThat(screen.getScreen(),is("#.#....\n" +
                                     "##.....\n" +
                                     ".##....\n"));
  }

  @Test
  public void should_rotate_row(){
    Screen screen = new Screen(3,7);
    screen.litCornerBy(3,2);
    screen.rotateRow(0,1);
    assertThat(screen.getScreen(),is(".###...\n" +
                                     "###....\n" +
                                     ".......\n"));
    screen.rotateRow(1,5);
    assertThat(screen.getScreen(),is(".###...\n" +
                                     "#....##\n" +
                                     ".......\n"));
  }

  @Test
  public void mock_input_test(){
    Screen screen = new Screen(3,7);
    screen.litCornerBy(3,2);
    screen.rotateColumn(1,1);
    screen.rotateRow(0,4);
    screen.rotateColumn(1,1);
    assertThat(screen.getScreen(),is(".#..#.#\n" +
                                     "#.#....\n" +
                                     ".#.....\n"));
  }

  @Test
  public void should_count_lit(){
    Screen screen = new Screen(3,7);
    screen.litCornerBy(3,2);
    screen.rotateColumn(1,1);
    screen.rotateRow(0,4);
    assertThat(screen.countLit(),is(6));
  }
}
