package day8;

public class Screen {
  private char[][] matrix ;

  public Screen(int rows, int columns) {
    this.matrix = new char[rows][columns];
    for(int i = 0; i< matrix.length;i++){
      for(int j = 0; j< matrix[0].length;j++){
        matrix[i][j]='.';
      }
    }
  }

  public String getScreen() {
    String screen="";
    for(int i = 0; i< matrix.length;i++){
      for(int j = 0; j< matrix[0].length;j++){
        screen +=matrix[i][j];
      }
      screen += "\n";
    }
    return screen;
  }

  public void litCornerBy(int y, int x) {
    for(int i = 0; i< x;i++){
      for(int j = 0; j< y;j++){
        matrix[i][j] = '#';
      }
    }
  }

  public void rotateColumn(int column, int n) {
    char[] copy = new char[matrix.length];
    for(int i = 0; i< matrix.length; i++){
      copy[(i+n)%matrix.length] = matrix[i][column];
    }
    for(int i = 0; i< matrix.length; i++){
      matrix[i][column] = copy[i];
    }
  }

  public void rotateRow(int row, int n) {
    char[] copy = new char[matrix[0].length];
    for(int i = 0; i< matrix[0].length; i++){
      copy[(i+n)%matrix[0].length] = matrix[row][i];
    }
    for(int i = 0; i< matrix[0].length; i++){
      matrix[row][i] = copy[i];
    }
  }

  public int countLit() {
    int count = 0;
    for (int i = 0; i<matrix.length;i++){
      for (int j = 0 ; j<matrix[0].length;j++){
        if (matrix[i][j]=='#'){
          count ++;
        }
      }
    }
    return count;
  }

  public void show() {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j]);

      }
      System.out.println();
    }
  }
}
