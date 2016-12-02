package Day2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumPadAdvTest {
  @Test
  public void shouldCreateNumPad(){
    NumPadAdv numPad = new NumPadAdv(2,2);
    assertThat(numPad.getChar(),is('7'));
  }

  @Test
  public void shouldMoveCorrectlyInBounds(){
    NumPadAdv numPadAdv = new NumPadAdv(2,2);
    numPadAdv.moveDown();
    assertThat(numPadAdv.getChar(),is('B'));
    numPadAdv.moveDown();
    numPadAdv.moveDown();
    assertThat(numPadAdv.getChar(),is('D'));
    numPadAdv.moveRight();
    numPadAdv.moveLeft();
    assertThat(numPadAdv.getChar(),is('D'));
    numPadAdv.moveUp();
    numPadAdv.moveLeft();
    numPadAdv.moveLeft();
    assertThat(numPadAdv.getChar(),is('A'));
    numPadAdv.moveUp();
    numPadAdv.moveUp();
    numPadAdv.moveUp();
    assertThat(numPadAdv.getChar(),is('2'));
  }

}
