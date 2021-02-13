package com.company;

public class LMS {

    public static void main(String[] args) {
        //points = {{1,4,1},{2,9,1},{5,6,1},{4,5,1},{6,0.7,-1},{1,1.5,-1}};
        double[] x1 = {1, 2, 5, 4, 6, 1};
        double[] x2 = {4, 9, 6, 5, 0.7, 1.5};
        double[] classVal = {-1, 1, 1, 1, -1, -1};
        String equation = LMSAlgorithm(x1, x2, classVal);
        System.out.println(equation);
    }

    public static String LMSAlgorithm(double[] x1, double[] x2, double[] classVal) {
        double W0 = 0.1;
        double W1 = 0.5;
        double W2 = 0.3;
        for (int i=0; i<500; i++) {
            for (int j=0; j<classVal.length; j++) {
                double temp = 1*W0+x1[j]*W1+x2[j]*W2;
                W0 = W0+0.01*(classVal[j]-temp);
                W1 = W1+0.01*(classVal[j]-temp)*x1[j];
                W2 = W2+0.01*(classVal[j]-temp)*x2[j];
            }
        }
        return "Wx = "+W0+" + "+W1+"x1 + "+W2+"x2";
    }
}
