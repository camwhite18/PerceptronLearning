package com.company;

public class Main {

    public static void main(String[] args) {
        //points = {{1,4,1},{2,9,1},{5,6,1},{4,5,1},{6,0.7,-1},{1,1.5,-1}};
        double[] x1 = {1, 2, 5, 4, 6, 1};
        double[] x2 = {4, 9, 6, 5, 0.7, 1.5};
        double[] classVal = {1, 1, 1, 1, -1, -1};
        String equation = perceptron(x1, x2, classVal);
        System.out.println(equation);

    }

    public static String perceptron(double[] x1, double[] x2, double[] classVal) {
        double W0 = 0;
        double W1 = 0;
        double W2 = 0;
        boolean allTrue = false;
        while (!allTrue) {
            allTrue = true;
            for (int i=0; i<classVal.length; i++) {
                double Wx = W0 + W1*x1[i] + W2*x2[i];
                if ((Wx > 0 && classVal[i]==-1) || (Wx <= 0 && classVal[i]==1)) {
                    allTrue = false;
                    W0 = W0 + classVal[i];
                    W1 = W1 + classVal[i]*x1[i];
                    W2 = W2 + classVal[i]*x2[i];
                }
            }
        }
        return "Wx = "+W0+" + "+W1+"x1 + "+W2+"x2";
    }
}
