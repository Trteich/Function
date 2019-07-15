package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {
    Function f;

    @BeforeEach
    void setUp() {
        f = new Function();
    }

    @Test
    void calculate() {
        double x = 1.5;
        double expected = 3.957472;
        double result = f.calculate(x);
        assertEquals(expected, result, 1e-6, "Error F for x < 1.7");

    }

    @Test
    void numberOfY() {
        double start = 0.8;
        double end = 2.0;
        double delta = 0.005;

        int expected = 241;
        int result = f.numberOfY(start, end, delta);
        assertEquals(expected, result, "Error in steps");

    }

    @Test
    void xInControlPoints() {
        double[] expected = {0.8, 1.7, 2};
        double[] x = f.fillX(0.8, 2.0, 0.005);
        double[] result = {x[0], x[180], x[240]};
        System.out.println(Math.log10(2 + 7 * Math.sqrt(2)));
        for (int i = 0; i < expected.length; i++) {
            System.out.println(expected[i] + "  " + result[i]);
            assertEquals(expected[i], result[i], 1e-6, "Error in " + i + "element");
        }
    }

    @Test
    void yInCotrolPoints() {
        double[] expected = {-8.92688, 16.496383, 1.075529};
        double[] x = f.fillX(0.8, 2.0, 0.005);
        double[] y = f.fillY(x);
        double[] result = {y[0], y[180], y[240]};

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i], 1e-6, "Error in " + i + " element");
        }
    }

}