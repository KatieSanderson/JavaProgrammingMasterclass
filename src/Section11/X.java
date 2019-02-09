package Section11;

import java.util.Scanner;

public class X {

    private int x;

    public static void main(String[] args) {
        X x = new X();
        x.x();
    }

    private void x() {
        try (Scanner x = new Scanner(System.in)) {
            this.x = x.nextInt();
        }
        for (int x = 1; x <= 12; x++) {
            System.out.println(this.x + " multiplied by " + x + " is " + (this.x * x));
        }
    }

}
