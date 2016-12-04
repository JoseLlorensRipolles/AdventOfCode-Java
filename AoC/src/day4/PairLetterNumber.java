package day4;

public class PairLetterNumber implements Comparable{

  private char letter;
  private int times;

  public PairLetterNumber(char letter, int times) {
    this.letter = letter;
    this.times = times;
  }

  public char getLetter() {
    return letter;
  }

  public int getTimes() {
    return times;
  }

  @Override
  public int compareTo(Object o) {
    PairLetterNumber other = (PairLetterNumber) o;
    if (this.times > other.getTimes()) {
      return -1;
    } else {
      if (this.times < other.getTimes()) {
        return 1;
      } else {
        return this.letter -other.getLetter();
      }
    }
  }
}
