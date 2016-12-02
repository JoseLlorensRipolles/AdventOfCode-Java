package Day2;

public class NumPad {
  char[][] numPad = new char[][]{{'7','8','9'},{'4','5','6'},{'1','2','3'}};
  int i, j;

  public NumPad( int i, int j) {
    this.i = i;
    this.j = j;
  }

  public void moveUp(){
    if(i<2) {i++;}
  }

  public void moveDown(){
    if(i>0) {i--;}
  }

  public void moveRight() {
    if(j<2) {j++;}
  }

  public void moveLeft(){
    if(j>0) {j--;}
  }

  public char getChar(){
    return numPad[i][j];
  }
}
