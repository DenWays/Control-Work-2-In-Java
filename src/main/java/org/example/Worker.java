//Создать базовый класс – работник, и производные классы – служащий с почасовой
//оплатой, служащий в штате и служащий с процентной ставкой. Определить функцию
//начисления зарплаты. Для каждого класса провести модульное тестирование
//основных методов класса.

package org.example;

public class Worker {
    private String name;
    private int age;

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return 1000;
    }

    public String toString() {
        return "Worker{" +
                "Имя='" + name + '\'' +
                ", возраст=" + age +
                '}';
    }
}

class WorkerHour extends Worker{
    private int hour;
    private int salaryInHour;

    public WorkerHour(String name, int age, int hour, int salaryInHour) {
        super(name, age);
        this.hour = hour;
        this.salaryInHour = salaryInHour;
    }

    @Override
    public double getSalary() {
        return hour * salaryInHour;
    }
}

class WorkerOnStaff extends Worker {
    public WorkerOnStaff(String name, int age) {
        super(name, age);
    }

    @Override
    public double getSalary() {
        return 10000;
    }
}

class WorkerWithProcent extends Worker {
    private int procent;

    public WorkerWithProcent(String name, int age, int procent) {
        super(name, age);
        this.procent = procent;
    }

    @Override
    public double getSalary() {
        return 100000 * (procent / 100);
    }
}