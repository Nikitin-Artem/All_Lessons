package com.company.StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Stream<Phone> phoneStream = Stream.of(
//                new Phone("iPhone 6 S", 54000),
//                new Phone("Lumia 950", 45000),
//                new Phone("Samsung Galaxy S 6", 40000)
//        );
//
//        phoneStream.filter(p -> p.getPrice() < 50000).forEach(p -> System.out.println(p.getName()));
//
//
//        //Плоское отображение выполняется тогда, когда из одного элемента нужно получить несколько. Данную операцию выполняет метод flatMap:
//        Stream<Phone> phoneStream2 = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000),
//                new Phone("Samsung Galaxy S 6", 40000));
//
//        phoneStream2
//                .flatMap(p -> Stream.of(
//                        String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()),
//                        String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int) (p.getPrice() * 0.1))
//                ))
//                .forEach(s -> System.out.println(s));
//
//
//        // сортировка с учетом регистров иначе тип неправильно сортирует, надо чекнуть
//        Stream<Phone> phoneStream3 = Stream.of(new Phone("iPhone X", "Apple", 600),
//                new Phone("Pixel 2", "Google", 500),
//                new Phone("iPhone 8", "Apple",450),
//                new Phone("Nokia 9", "HMD Global",150),
//                new Phone("Galaxy S9", "Samsung", 300));
//
//        phoneStream3.sorted(new PhoneComparator())
//                .forEach(p->System.out.printf("%s (%s) - %d \n",
//                        p.getName(), p.getCompany(), p.getPrice()));
//
//
//
//        // Тип разделение по страницам
//        List<String> phones = new ArrayList<String>();
//        phones.addAll(Arrays.asList(new String[]
//                {"iPhone 6 S", "Lumia 950", "Huawei Nexus 6P",
//                        "Samsung Galaxy S 6", "LG G 4", "Xiaomi MI 5",
//                        "ASUS Zenfone 2", "Sony Xperia Z5", "Meizu Pro 5",
//                        "Lenovo S 850"}));
//
//        int pageSize = 3; // количество элементов на страницу
//        Scanner scanner = new Scanner(System.in);
//        while(true){
//
//            System.out.println("Введите номер страницы: ");
//            int page = scanner.nextInt();
//
//            if(page<1) break; // если число меньше 1, выходим из цикла
//
//            phones.stream().skip((page-1) * pageSize)
//                    .limit(pageSize)
//                    .forEach(s->System.out.println(s));
//        }


        List<Employee> employeeCollection = Arrays.asList(
                new Employee("Michael", "Smith", 243, 43, Position.CHEF),
                new Employee("Jane", "Smith", 523, 40, Position.MANAGER),
                new Employee("Jury", "Gagarin", 6423, 26, Position.PEPEGA),
                new Employee("Jack", "London", 5543, 53, Position.WORKER),
                new Employee("Eric", "Jackson", 2534, 22, Position.WORKER)
        );

        /** Вывести список имен сотрудников                                                         **/
        employeeCollection.forEach(employee -> System.out.println(employee.firstName));

        /** Поиск самого старого сотрудника                                                         **/
        employeeCollection.stream().max(Comparator.comparingInt(Employee::getAge));

        /** Количество человек с фамилией Smith                                                     **/
        System.out.println(employeeCollection.stream().filter(emp -> emp.getLastName().equals("Smith")).count());

        /** Поиск сотрудников в чъей фамилии есть символы "Smi"                                     **/
        employeeCollection.stream().filter(employee -> employee.getLastName().contains("Smi")).forEach(System.out::println);

        /** Проверяем все ли сотрудники старше 18                                                   **/
        employeeCollection.stream().anyMatch(employee -> employee.getAge() > 18); //true

        /** Преобразовать stream в другой вид коллекции (например List)                             **/
        employeeCollection.stream().collect(Collectors.toList());

        /** Новый Stream в котором нет никого с должностью CHEF                                     **/
        Stream<Employee> employeeStream1 = employeeCollection.stream().filter(employee -> employee.getPosition() != Position.CHEF);

        /** Новый Stream в котором все сотрудники старше 30                                         **/
        Stream<Employee> employeeStream2 = employeeCollection.stream().filter(employee -> employee.getAge() > 30);
        employeeStream2.forEach(System.out::println);

        /** Сортировка по возрасту или фамилии                                                      **/
        employeeCollection.stream().sorted(Comparator.comparingInt(Employee::getAge));
        employeeCollection.stream().sorted(Comparator.comparing(Employee::getLastName));

        // Фильтруем по возрасту и выводим только имя и фамилию
        employeeCollection.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .map(emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName()))
                .forEach(System.out::println);

        /** Поиск самых старых сотрудников                                                          **/
        employeeCollection.stream()
                .filter(employee -> employee.getAge() > 20)         // Всех кто старше 20
                .sorted((x1, x2) -> x2.getAge() - x1.getAge())      // В обратном порядке
                .limit(4)                                           // Максимум 4
                .forEach(System.out::println);

        /** Преобразовать stream в мапу, где ключ - id, а значение - фамилия, возраст и должность   **/
        Map<Integer, String> collect = employeeCollection.stream().collect(Collectors.toMap(
                Employee::getId,
                x -> String.format("\t%8s %3d %8s", x.getLastName(), x.getAge(), x.getPosition())
        ));

        List<Map.Entry<Integer, String>> mapList = new ArrayList<>(collect.entrySet());
        mapList.forEach(System.out::println);

    }
}

class PhoneComparator implements Comparator<Phone> {

    public int compare(Phone a, Phone b) {

        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}
