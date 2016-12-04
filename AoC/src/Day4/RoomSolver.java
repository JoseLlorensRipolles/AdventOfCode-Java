package Day4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomSolver {
  public RoomSolver() {
  }

  public int getSumIdReals() {
    String input = null;

    try {
      input = new String(Files.readAllBytes(Paths.get("input.txt")));
    } catch (IOException e) {
      System.err.println(e);
    }

    System.out.println(input);
    return 0;
  }

  public Boolean isReal(String s) {

    String regex = "(.*)-\\d*.(\\D*).$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(s);

    matcher.find();
    String roomName = matcher.group(1);
    String checkSum = matcher.group(2);

    roomName = roomName.replaceAll("-","");

    Map<Character,Integer> map = new HashMap();

    char[] roomNameChar = roomName.toCharArray();
    for(char letter : roomNameChar){
      if(!map.containsKey(letter)){
        map.put(letter,1);
      }else{
        int times = map.get(letter);
        times++;
        map.put(letter,times);
      }
    }

    PriorityQueue<PairLetterNumber> priorityQueue = new PriorityQueue<>();
    for(char letter : map.keySet()){
      priorityQueue.add(new PairLetterNumber(letter,map.get(letter)));
    }

    char[] checksumChar = checkSum.toCharArray();

    for(char letter : checksumChar){
      if(letter != priorityQueue.poll().getLetter()){
        return false;
      }
    }
    return true;
  }

  public int solvePart1() {
    int count = 0 ;
    String[] lines = null;
    try {
      String input = new String(Files.readAllBytes(Paths.get("/home/josellorens/Code/JavaCode/AoC/src/Day4/input.txt")));
      //String input = new String(Files.readAllBytes(new File("input.txt").get));
      lines = input.split("\n");
    } catch (Exception e) {
      System.err.println(e);
      System.exit(26);
    }

    for(String line : lines){
      if(isReal(line)){
        count += extractId(line);
      }
    }

    return count;
  }

  public int extractId(String line) {
    String regex = "(.*)-(\\d*).(\\D*).$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(line);

    matcher.find();
    return Integer.parseInt(matcher.group(2));
  }

  public String shiftRoom(String s, int id){
    char[] roomChars = s.toCharArray();
    for(int i = 0 ; i< roomChars.length; i++){
      if(roomChars[i] != '-'){
        char letter = roomChars[i];
        letter -= 97;
        letter +=id;
        letter = (char)(letter % 26);
        letter += 97;
        roomChars[i] = letter;
      }
    }
    return new String(roomChars).replaceAll("-"," ");
  }
}
