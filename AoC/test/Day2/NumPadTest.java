package Day2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumPadTest {

  @Test
  public void shouldCreateNumPad(){
    NumPad numPad = new NumPad(0,0);
    assertThat(numPad.getChar(),is('7'));
  }

  @Test
  public void shouldMoveCorrectlyInBounds(){
    NumPad numPad = new NumPad(1,1);
    numPad.moveUp();
    assertThat(numPad.getChar(),is('2'));
    numPad.moveRight();
    assertThat(numPad.getChar(),is('3'));
    numPad.moveRight();
    numPad.moveRight();
    numPad.moveRight();
    assertThat(numPad.getChar(),is('3'));
    numPad.moveUp();
    numPad.moveUp();
    assertThat(numPad.getChar(),is('3'));
    numPad.moveLeft();
    numPad.moveLeft();
    numPad.moveLeft();
    numPad.moveLeft();
    assertThat(numPad.getChar(),is('1'));
    numPad.moveDown();
    numPad.moveDown();
    numPad.moveDown();
    numPad.moveDown();
    assertThat(numPad.getChar(),is('7'));
  }

}
