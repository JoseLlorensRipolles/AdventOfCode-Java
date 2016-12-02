package Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
  public static void main(String[] args){
    Scanner in  = new Scanner(System.in);
    List<String> instructions = new ArrayList<String>();

    //If you want solve part 2 comment next line and uncomment the "NumPadAdv numPad = new NumPadAdv(2,2)"

     NumPad numPad = new NumPad(1, 1);
    //NumPadAdv numPad = new NumPadAdv(2,2);

    for(int i = 0; i<5 ; i++){
      instructions.add(in.nextLine());
    }

    for(String aux : instructions){
      char[] instruction = aux.toCharArray();

      for(int i = 0; i< instruction.length;i++){
        switch (instruction[i]){
          case ('R'):
            numPad.moveRight();
            break;
          case ('L'):
            numPad.moveLeft();
            break;
          case ('D'):
            numPad.moveDown();
            break;
          case ('U'):
            numPad.moveUp();
            break;
        }
      }

      System.out.print(numPad.getChar());
    }



  }
}
