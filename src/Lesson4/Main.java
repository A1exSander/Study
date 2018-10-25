package Lesson4;

public class Main {
    public static void main(String[] args) {
        Good door = new Good("Лверь", 1000);
        System.out.println(door.toString());
        Good table = new Good();
        table.setTitle("Стол");
        table.setPrice(700);
        System.out.println(table.toString());

        Good chair = new Good();
        chair.setPrice(200);
        chair.setTitle("Стул");

        System.out.println(chair.toString());

        Storage storage = new Storage();
        storage.addGood(chair);
        storage.addGood(chair);
        storage.addGood(table);
        storage.addGood(chair);
        storage.showGoods();
    }
}
