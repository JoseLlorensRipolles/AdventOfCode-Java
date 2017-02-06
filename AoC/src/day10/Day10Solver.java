package day10;

import day8.Screen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JoseLlorens on 06/02/2017.
 */
public class Day10Solver {

  public int solvePart1() throws IOException {
    Bot[] bots = new Bot[500];
    int[] outputs = new int[100];

    for(int i = 0; i<100; i++){
      outputs[i] = -1;
    }

    for (int i = 0; i< 500 ; i++){
      bots[i] = new Bot(i);
    }
    Queue<Bot> botsReady = new ArrayDeque<>();
    BufferedReader bf = null;
    try {
      bf = new BufferedReader(new FileReader("src/day10/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    String line = null;

    while ((line = bf.readLine()) != null) {
      if (line.startsWith("bot")) {
        String regex = "bot (\\d*) gives low to (\\w*) (\\d*) and high to (\\w*) (\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();

        int id = Integer.parseInt(matcher.group(1));
        int lowTo =Integer.parseInt(matcher.group(3));
        int highTo =Integer.parseInt(matcher.group(5));
        boolean lowToOutput = matcher.group(2).equals("output");
        boolean highToOutput = matcher.group(4).equals("output");
        bots[id].init(lowTo,highTo,lowToOutput,highToOutput);
      }else{
        String regex = "value (\\d*) goes to bot (\\d*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();

        int value = Integer.parseInt(matcher.group(1));
        int id = Integer.parseInt(matcher.group(2));
        bots[id].giveChip(value);
        if(bots[id].isReady()){
          if(bots[id].isTheOne()){
            return id;
          }
          botsReady.add(bots[id]);
        }
      }
    }

    while(!botsReady.isEmpty()){
      Bot bot = botsReady.poll();
      int lowTo = bot.getLowTo();
      int highTo = bot.getHighTo();
      int lowValue = bot.getLowValue();
      int highValue = bot.getHighValue();
      boolean isLowOutput = bot.isLowOutput();
      boolean isHighOutput = bot.isHighOutput();
      bot.setEmpty();

      if(!isLowOutput){
        bots[lowTo].giveChip(lowValue);
        if(bots[lowTo].isReady()){
          if(bots[lowTo].isTheOne()){
            System.out.println(lowTo);
          }
          botsReady.add( bots[lowTo]);
        }
      }else{
        outputs[lowTo] = lowValue;
      }

      if(!isHighOutput){
        bots[highTo].giveChip(highValue);
        if(bots[highTo].isReady()){
          if(bots[highTo].isTheOne()){
            System.out.println(highTo);
          }
          botsReady.add(bots[highTo]);
        }
      }else{
        outputs[highTo] = highValue;
      }
    }

    int count = 1;
    count *= outputs[0];
    count *= outputs[1];
    count *= outputs[2];
    System.out.println(count);
    return -1;
  }

}


