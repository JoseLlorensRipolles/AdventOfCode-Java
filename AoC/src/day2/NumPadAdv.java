package day2;

public class NumPadAdv {
  char[][] numPad = new char[][]{{'-','-','D','-','-'}
                                ,{'-','A','B','C','-'},
                                 {'5','6','7','8','9'},
                                 {'-','2','3','4','-'},
                                 {'-','-','1','-','-'}};

  int i, j;


  public NumPadAdv(int i, int j) {
    this.i = i;
    this.j = j;
  }

  public void moveUp(){
    if(i<4){
      if(numPad[i+1][j]!='-'){
        i++;
      }
    }
  }

  public void moveDown(){
    if(i>0){
      if(numPad[i-1][j]!='-'){
        i--;
      }
    }
  }

  public void moveRight(){
    if(j<4){
      if(numPad[i][j+1]!='-'){
        j++;
      }
    }
  }

  public void moveLeft(){
    if(j>0){
      if(numPad[i][j-1]!='-'){
        j--;
      }
    }
  }


  public char getChar(){
    return numPad[i][j];
  }
}
