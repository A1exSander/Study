package lesson13Homework.syn3;

public class Dog {
    private static int counter=0;
    int weight, age;
    String name, color, address;

    public Dog(String name, int weight, int age) {
        if (weight > 0) {
            this.weight = weight;
            if (age > 0) {
                this.age = age;
                this.name = name;
                counter++;
            }
        }
    }

    public Dog(String name, int age) {
        if (age > 0) {
            this.age = age;
            this.name = name;
            this.weight = 15;
            counter++;
        }
    }

    public Dog(String name) {
        this.name = name;
        this.weight = 15;

        counter++;
    }

    public Dog(int weight, String color, String address) {
        if (weight > 0) {
            this.weight = weight;
            this.color = color;
            this.address = address;
            counter++;
        }
    }

    public Dog(int weight, String color) {
        if (weight > 0) {
            this.weight = weight;
            this.color = color;
            counter++;
        }
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='"  + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
