package day10;

/**
 * Created by JoseLlorens on 06/02/2017.
 */
public class Bot {
  int id;
  int chipA, chipB;
  int lowTo, highTo;
  boolean lowToOutput, highToOutput;
  boolean readyToGive;

  public Bot(int id) {
    this.id = id;
    chipA = -1;
    chipB = -1;
  }

  public void init(int lowTo, int highTo, boolean lowToOutput, boolean highToOutput){
    this.lowTo = lowTo;
    this.highTo = highTo;
    this.lowToOutput = lowToOutput;
    this.highToOutput = highToOutput;
  }

  public void giveChip(int x){
    if(chipA == -1 ){
      chipA = x;
    }else{
      chipB = x;
      readyToGive = true;
    }
  }


  public boolean isReady(){
    return readyToGive;
  }


  public boolean isTheOne(){
    return ((chipA == 61 && chipB == 17) || chipA == 17 && chipB == 61);
  }

  public int getLowTo() {
    return lowTo;
  }

  public int getHighTo() {
    return highTo;
  }

  public int getLowValue() {
    if(chipB<chipA){
      return chipB;
    }else{
      return chipA;
    }
  }

  public int getHighValue() {
    if(chipB>chipA){
      return chipB;
    }else{
      return chipA;
    }
  }

  public boolean isLowOutput() {
    return lowToOutput;
  }

  public boolean isHighOutput() {
    return highToOutput;
  }

  public void setEmpty() {
    chipA = -1;
    chipB = -1;
  }
}
