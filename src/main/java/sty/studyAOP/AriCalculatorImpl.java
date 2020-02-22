package sty.studyAOP;

import org.springframework.stereotype.Component;

@Component
public class AriCalculatorImpl implements AriCalculator {
    public int add(int i, int j) { return i + j; }

    public int del(int i, int j) {
        return i - j;
    }

    public int div(int i, int j) {
        return i / j;
    }
}
