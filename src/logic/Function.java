package logic;

public class Function {

    public Function() {
    }

    double calculate(double x) {
        double EPS = 1e-6;
        if (x < 1.7 - EPS) return (Math.PI * Math.pow(x, 2)) - (7 / Math.pow(x, 2));
        double a = 1.5;
        if (x > 1.7 + EPS) return Math.log10(x + (7 * Math.sqrt(x)));
        return (a * Math.pow(x, 3)) + (7 * Math.sqrt(x));
    }


    public int numberOfY(double start, double end, double delta) {
        return (int) ((end - start) / delta) + 1;
    }

    public double[] fillX(double start, double end, double delta) {
        double[] x = new double[numberOfY(start, end, delta)];

        for (int i = 0; i < x.length; i++) {
            x[i] = start + i * delta;
        }
        return x;
    }

    public double[] fillY(double[] x) {
        double[] y = new double[x.length];

        for (int i = 0; i < y.length; i++)
            y[i] = calculate(x[i]);

        return y;
    }

    public int getMax(double[] y) {
        int index = -1;
        double max = -999999999;
        for (int i = 0; i < y.length - 1; i++) {
            if (y[i] > max) {
                max = y[i];
                index = i;
            }
        }

        return index;
    }

    public int getMin(double[] y) {
        int index = -1;
        double min = 999999999;
        for (int i = 0; i < y.length - 1; i++) {
            if (y[i] < min) {
                min = y[i];
                index = i;
            }
        }

        return index;
    }

    public double getSum(double[] y) {
        double sum = 0;

        for (double m : y) sum += m;

        return sum;
    }

    public double getAverage(double[] y) {
        double sum = 0;

        for (double m : y) sum += m;

        return sum / y.length;
    }
}
