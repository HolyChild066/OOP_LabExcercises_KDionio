public class Person {
    protected String name;
    protected int age;

    public Person() {
        this.name = "";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method overloading - same name, different parameters
    public Person(String name) {
        this.name = name;
        this.age = 0;
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

    // Method to be overridden (Runtime Polymorphism)
    public void displayInfo() {
        System.out.println("Person: " + name + ", Age: " + age);
    }

    public String getRole() {
        return "Person";
    }
}