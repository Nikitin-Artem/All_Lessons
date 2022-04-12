package com.company.Map.HashMap.Exercise;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //--- 1. Поиск по возрасту в диапозоне

        HashMap<String, Customer> customerMap = new HashMap<>();

        customerMap.put("3", new Customer("Максим", 48));
        customerMap.put("1", new Customer("Павел", 23));
        customerMap.put("2", new Customer("Олег", 17));
        customerMap.put("4", new Customer("Евгения", 67));

        System.out.println(fromToSearch(customerMap, 1, 30));

        List<Map.Entry<String, Customer>> entryList = new ArrayList<>(customerMap.entrySet());
        System.out.println(entryList);

        //--- 2. Поиск уникальных дубликатов и их количество

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");
        System.out.println(uniqueWords(words));

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strings = str.split(" ");

        List<String> list = Arrays.asList(strings);
        System.out.println(uniqueWords(list));
    }

    public static HashMap<String, Customer> fromToSearch(HashMap<String, Customer> allMap, int from, int to) { // Можно сделать через void
        HashMap<String, Customer> fromToMap = new HashMap<>();
        for (Map.Entry<String, Customer> entry : allMap.entrySet()) {
            if (entry.getValue().getAge() > from && entry.getValue().getAge() < to) {
                fromToMap.put(entry.getKey(), entry.getValue());
            }
        }
//        for (Map.Entry<String, Customer> entry : fromToMap.entrySet()) {
//            System.out.println(entry.getKey() + " name: " + entry.getValue() + ", age: " + entry.getValue().getAge());
//        }
        return fromToMap;
    }


    public static HashMap<String, Integer> uniqueWords(List<String> array) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str : array) {
            if (hashMap.containsKey(str)) {
                hashMap.put(str, hashMap.get(str) + 1);
            } else {
                hashMap.put(str, 1);
            }
        }
        return hashMap;
    }
}
