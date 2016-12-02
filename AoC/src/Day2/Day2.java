package Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
  public static void main(String[] args){
    Scanner in  = new Scanner(System.in);
    List<String> instructions = new ArrayList<String>();
    NumPad numPad = new NumPad(1,1);

    for(int i = 0; i<5 ; i++){
      instructions.add(in.nextLine());
    }

    for(String aux : instructions){
      char[] instruction = aux.toCharArray();

      for(int i = 0; i< instruction.length;i++){
        switch (instruction[i]){
          case ('R'):
            numPad.goRight();
            break;
          case ('L'):
            numPad.goLeft();
            break;
          case ('D'):
            numPad.goDown();
            break;
          case ('U'):
            numPad.goUp();
            break;
        }
      }

      System.out.print(numPad.getNum());
    }



  }
}
