package day3;

public class Triangle {
  int a,b,c;


  public Triangle(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public boolean isPossible(){
    return (a+b>c && a+c>b && b+c>a);
  }

  public boolean equals(Triangle other){
    return  this.a == other.getA() &&
            this.b == other.getB() &&
            this.c == other.getC();
  }

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }

  public int getC() {
    return c;
  }
}
