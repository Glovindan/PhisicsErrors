package com.company;

public class Main {
    public static final double[] x = {16, 15, 14, 14, 14, 14};//Многократные измерения

    public static final double[] student = {6.315, 2.920, 2.353,
                                            2.132, 2.015, 1.943,
                                            1.895, 1.868, 1.833,
                                            1.813};//Коэф Стьюдента
    public static final double sysErr = 0.5;//Погрешность прибора
    public static final double adduction = 9.8;//Коэф для приведения

    public static double root( double n, double i ) {//Корень
        return Math.pow( n, 1.0 / i );
    }

    public static double pow( double n, double i ) {//Степень
        return Math.pow( n, i);
    }

    public static double average(double[] x) {//Среднее значение
        double answer = 0;
        int xLength = x.length;
        for (int i = 0; i < xLength; i++) {
            answer += x[i];
        }
        answer = answer/xLength;
        return answer;
    };

    public static double standardDeviation(double[] x, double xAverage) {//Среднее квадратичное
        double answer = 0;
        int xLength = x.length;
        for (int i = 0; i < xLength; i++) {
            answer += pow(x[i] - xAverage, 2);
        }
        answer = root(answer /(xLength * (xLength - 1)), 2);
        return answer;
    };
    public static void main(String[] args) {
        double xAverage = average(x);
        double xSD = standardDeviation(x, xAverage);
        double accErr = student[x.length - 1] * xSD;//Случайная ошибка
        double absErr = root(pow(accErr,2) + pow(sysErr,2), 2);//Абсолютная ошибка

        System.out.println("Average = "+xAverage);
        System.out.println("Standard deviation = "+xSD);
        System.out.println("Accidental error = "+accErr);
        System.out.println("Absolute error = "+absErr);
        System.out.println("End value = "+xAverage+" ± "+absErr);

        double xAverageAdducted = xAverage * adduction;
        double absErrAdducted = absErr * adduction;

        System.out.println("End value adducted= "+xAverageAdducted+" ± "+absErrAdducted);//Типа перевел мм в Н
    }
}
