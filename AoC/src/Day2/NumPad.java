package Day2;

public class NumPad {
  int[][] numPad = new int[][]{{7,8,9},{4,5,6},{1,2,3}};
  int i, j;

  public NumPad( int i, int j) {
    this.i = i;
    this.j = j;
  }

  public void goUp(){
    if(i<2) {i++;}
  }

  public void goDown(){
    if(i>0) {i--;}
  }

  public void goRight() {
    if(j<2) {j++;}
  }

  public void goLeft(){
    if(j>0) {j--;}
  }

  public int getNum(){
    return numPad[i][j];
  }
}
