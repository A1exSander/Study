package lesson4;

//шаблон товара
public class Good {
    //свойства
    private String title;
    private int price;

    //Конструктор. Запускается каждый раз в момент создания объекта
    public Good(String title, int price) {
        this.title = title;
        this.price = price;
    }
    public Good() {}

    //Можно использовать несколько. Если в конструкторе нужны переменные, то выйдет ошибка, если их не передать. Выход - описать все варианты конструкторами

    public String getTitle() {
        return title;
    }

    //методы установки характеристик
    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() { //атрибут приватности, тип возвращаемых данных (void, если ничего), название метода
        return "Good{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
