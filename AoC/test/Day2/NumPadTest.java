package Day2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumPadTest {

  @Test
  public void shouldCreateNumPad(){
    NumPad numPad = new NumPad(0,0);
    assertThat(numPad.getNum(),is(7));
  }

  @Test
  public void shouldMoveCorrectlyInBounds(){
    NumPad numPad = new NumPad(1,1);
    numPad.goUp();
    assertThat(numPad.getNum(),is(2));
    numPad.goRight();
    assertThat(numPad.getNum(),is(3));
    numPad.goRight();
    numPad.goRight();
    numPad.goRight();
    assertThat(numPad.getNum(),is(3));
    numPad.goUp();
    numPad.goUp();
    assertThat(numPad.getNum(),is(3));
    numPad.goLeft();
    numPad.goLeft();
    numPad.goLeft();
    numPad.goLeft();
    assertThat(numPad.getNum(),is(1));
    numPad.goDown();
    numPad.goDown();
    numPad.goDown();
    numPad.goDown();
    assertThat(numPad.getNum(),is(7));
  }

}
