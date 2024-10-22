//Создать базовый класс с функцией – сумма прогрессии. Создать производные классы:
//арифметическая прогрессия и геометрическая прогрессия. Каждый класс имеет два
//поля типа double. Первое – первый член прогрессии, второе – постоянная разность
//(для арифметической) и постоянное отношение (для геометрической). Определить
//функцию вычисления суммы, где параметром является количество элементов
//прогрессии.
package org.example;

abstract class SumProgression {
    protected double a1;

    public SumProgression(double a1) {
        this.a1 = a1;
    }

    abstract double getSum(int n);
}

class ArithmeticProgression extends SumProgression {
    private double d;
    public ArithmeticProgression(double a1, double d) {
        super(a1);
        this.d = d;
    }

    @Override
    double getSum(int n) {
        return ((2 * (super.a1) + (n - 1) * d) / 2) * n;
    }
}

class GeometricProgression extends SumProgression {
    private double q;
    public GeometricProgression(double a1, double q) {
        super(a1);
        this.q = q;
    }

    @Override
    double getSum(int n) {
        return (super.a1 * (Math.pow(q, n) - 1)) / (q - 1);
    }
}
