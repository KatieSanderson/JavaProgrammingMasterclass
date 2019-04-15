package Section16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Lambdas {

    public static void main(String[] args) {
        Employee john = new Employee("John W", 30);
        Employee katie = new Employee("Katie S", 26);
        Employee bradley = new Employee("Bradley W", 26);
        Employee tim = new Employee("Tim B", 50);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(katie);
        employees.add(bradley);

        Function<Employee, String> getLastName = ((Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        });

        String lastName = getLastName.apply(employees.get(1));
//        System.out.println(lastName);

        Function<Employee, String> getFirstName = ((Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        });

        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i * 5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello World");

    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        employees.forEach(employee -> {
            if(ageCondition.test(employee)) {
                System.out.println(employee.getName());

            }
        });
    }

}
