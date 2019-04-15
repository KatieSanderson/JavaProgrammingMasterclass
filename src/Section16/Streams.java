package Section16;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N10", "N36",
                "B12", "B6",
                "G53", "G49", "G68", "G50", "g64",
                "I26", "I17", "I29",
                "O71");
        List<String> gNumbers = new ArrayList<>();
//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
////                System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
//                .map(s -> s.toUpperCase())
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

//        list.forEach(System.out::println);
        Stream<String> numberStream = Stream.of("I26", "I17", "I29", "G71");
        Stream<String> numberStream2 = Stream.of("N18", "N26", "I26", "O71");
        Stream<String> concatStream = Stream.concat(numberStream, numberStream2);
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        Employee john = new Employee("John Doe", 30);
        Employee katie = new Employee("Katie Sanderson", 26);
        Employee bradley = new Employee("Bradley Wyatt", 27);
        Employee jake = new Employee("Jake Hill", 40);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(katie);
        hr.addEmployee(bradley);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(jake);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out :: println);

        List<String> sortedNumber = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList :: new, ArrayList :: add, ArrayList :: addAll);

        for (String s : sortedNumber) {
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out :: println);

        Stream.of("ABC", "DEF", "GHI", "AC", "BAA", "CCCC", "XY")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();

        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i %2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("1234567890"));

        System.out.println(everySecondCharacter(lambdaFunction, "123456789"));


        Supplier<String> iLJ = () -> "I love java";
        Supplier<String> iLJ2 = () -> {
            return "I Love java";
        };

        Supplier supplier = () -> {
            String iLoveJava = "I love Java";
            return iLoveJava;
        };

        System.out.println(iLJ.get());

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach (name ->
                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        firstUpperCaseList.sort(String :: compareTo);
        firstUpperCaseList.forEach(System.out::println);

        System.out.println(Arrays.toString(topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .peek(System.out::println)
                .filter(s -> s.charAt(0) == 'A')
//                .sorted()
//                .count();
//                .forEach(System.out::println);
                .toArray()));

//        System.out.println(nameCount);

    }

    public static String everySecondCharacter(Function<String, String> func, String s) {
        return func.apply(s);
    }
}
