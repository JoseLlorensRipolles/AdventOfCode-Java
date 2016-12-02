package Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2Part2 {
  public static void main(String[] args){
    Scanner in  = new Scanner(System.in);
    List<String> instructions = new ArrayList<String>();
    NumPadAdv numPadAdv = new NumPadAdv(2,2);

    for(int i = 0; i<5 ; i++){
      instructions.add(in.nextLine());
    }

    for(String aux : instructions){
      char[] instruction = aux.toCharArray();

      for(int i = 0; i< instruction.length;i++){
        switch (instruction[i]){
          case ('R'):
            numPadAdv.moveRight();
            break;
          case ('L'):
            numPadAdv.moveLeft();
            break;
          case ('D'):
            numPadAdv.moveDown();
            break;
          case ('U'):
            numPadAdv.moveUp();
            break;
        }
      }

      System.out.print(numPadAdv.getChar());
    }



  }
}
