package lesson17_18.patterns.decorator;

public class Main {
    public static void main(String[] args) {
        IService service = new Service2(new WashDecorator(new TO()));
        System.out.println(service.getPrice());
        System.out.println(service.getDescription());

        IService service2 = new Service2(new ServiceDecorator(new TO()));
        System.out.println(service2.getPrice());
        System.out.println(service2.getDescription());

    }

}
