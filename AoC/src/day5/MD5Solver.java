package day5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Solver {

  public MD5Solver() {

  }

  //Copied from "https://www.mkyong.com/java/java-md5-hashing-example/"
  public String MD5Hash(String s) {
    MessageDigest md = null;

    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    md.update(s.getBytes());

    byte[] byteData = md.digest();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < byteData.length; i++) {
      sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }

  public boolean checkIfFiveZeroes(String s) {
    if (s.length() < 5) {
      return false;
    } else {
      String z = s.substring(0, 5);
      return z.equals("00000");
    }
  }

  public boolean checkIfInBounds(char c) {
    return c-48 < 8;
  }

  public String solvePart1(String id) {
    int count = 0, letters = 0;
    char[] solution = new char[8];

    while (letters < 8) {
      String aux = id + count;
      String hash = MD5Hash(aux);
      if (checkIfFiveZeroes(hash)) {
        solution[letters] = hash.charAt(5);
        letters++;
      }
      count++;
    }

    return new String(solution);
  }


  public String solvePart2(String id) {
    int count = 0, letters = 0;
    char[] solution = new char[8];
    boolean[] finded = new boolean[8];
    String aux,hash;

    while (letters < 8) {
      aux = id + count;
      hash = MD5Hash(aux);
      if (checkIfFiveZeroes(hash)) {

        if(checkIfInBounds(hash.charAt(5)) && !finded[hash.charAt(5)-48]){

          finded[hash.charAt(5)-48] = true;
          solution[hash.charAt(5)-48] = hash.charAt(6);
          letters++;

        }
      }
      count++;
    }

    return new String(solution);
  }

}

