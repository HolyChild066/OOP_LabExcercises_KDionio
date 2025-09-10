class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }

    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Ana", 20);
        Student s2 = new Student("Mark", 22);

        s1.displayInfo();
        s2.displayInfo();
    }
}
