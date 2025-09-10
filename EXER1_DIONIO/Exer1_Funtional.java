import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }

    int getAge() { return age; }
    String getName() { return name; }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ana", 20),
            new Student("Mark", 22),
            new Student("Liza", 19)
        );

        // Functional: pure transformation using functions
        Function<Student, String> getName = Student::getName;
        Predicate<Student> isAdult = s -> s.getAge() >= 21;

        List<String> adultNames = students.stream()
            .filter(isAdult)
            .map(getName)
            .toList();

        adultNames.forEach(System.out::println);
    }
}
