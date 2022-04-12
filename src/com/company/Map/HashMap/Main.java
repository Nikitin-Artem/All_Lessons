package com.company.Map.HashMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); // Словарь
        map.put(2, "Anna");
        map.put(1, "Peter");
        map.put(3, "Nasty");


        /**     1. Перебор всех значений            */
        // Вариант 1
        for (Map.Entry<Integer, String> entry : map.entrySet()) { // метод entrySet() возвращает множество (Set) пар, которые можно перебрать в цикле
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // Вариант 2
        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator(); // iterator – это интерфейс Iterator? Или интерфейс —  это паттерн?» паттерн — это шаблон проектирования, некое поведение, которого должен придерживаться класс или множество взаимосвязанных классов.
        while (itr.hasNext()) {
            Map.Entry<Integer, String> entry = itr.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        /**     2. Конвертировать Map в List        */
        List<Integer> keyList = new ArrayList<>(map.keySet());
        List<String> valueList = new ArrayList<>(map.values());
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(map.entrySet());
        System.out.println(entryList);

        /**     3. Сортировка ключей мапы           */
        // Вариант 1
        List<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        // Вариант 1.2 через лямбду
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getKey));

        // Вариант 2 (В отличие от первого способа, используя SortedMap, мы всегда будем хранить данные в отсортированном виде.)
        SortedMap<Integer, String> sortedMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // Вариант 2.2 через лямбду
        SortedMap<Integer, String> sortedMap1 = new TreeMap<>(Comparator.comparingInt(o -> o));

        /**     4. Сортировка значений мапы         */
        List<Map.Entry<Integer, String>> valueList1 = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // Вариант через лямбду
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
    }
}
