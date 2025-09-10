import java.util.*;
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

        // Declarative: filter and project
        List<String> result = students.stream()
            .filter(s -> s.getAge() > 20)
            .map(Student::getName)
            .toList();

        System.out.println(result);
    }
}
