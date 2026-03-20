package Calculator;

public class Calculator {
  public int add(int a, int b) {
    if(a == 0 || b == 0) {
      throw new Error("Operands cannot be zero");
    }
    return a + b;
  }
}