package com.company.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        Car ferrari = new Car(1990, "Ferrari 360 Spider", 310);
        Car lambo = new Car(2012, "Lamborghini Gallardo", 290);
        Car bugatti = new Car(2010, "Bugatti Veyron", 350);

        cars.add(ferrari);
        cars.add(bugatti);
        cars.add(lambo);

        /**
         * Был переопределен метод 'compareTo()' интерфейса 'Comparable' в классе 'Car' для сортировки по году выпуска.
         * в методе 'compareTo()' ты описываешь наиболее распространенный способ сравнения, который будет использоваться
         * для объектов этого класса в твоей программе, а для более частных случаев уже используется другой типизированный
         * интерфейс 'Comparator', использующий метод 'compare'.
         */

        System.out.println("Сортировка по дате");
        Collections.sort(cars);                     // Override сортировка по году через 'Comparable'
        System.out.println(cars);

        System.out.println("\nСортировка по скорости");
        Comparator speedComparator = new MaxSpeedCarComparator();
        Collections.sort(cars, speedComparator);    // Override сортировка по скорости через 'Comparator'
        System.out.println(cars);

        System.out.println("\nСортировка по модели");
        Comparator modelComparator = new ModelCarComparator();
        Collections.sort(cars, modelComparator);    // Override сортировка по модели через 'Comparator'
        System.out.println(cars);
    }
}