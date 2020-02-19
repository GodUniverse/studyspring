package sty.studyproxy;

public class AriCalculatorImpl implements AriCalculator {
    public int add(int i, int j) {
        System.out.println("add...~ggg");
        return i + j;
    }

    public int del(int i, int j) {
        return i - j;
    }

    public int mul(int i, int j) {
        return i * j;
    }
}
