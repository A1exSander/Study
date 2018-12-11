package lesson17_18.patterns.decorator;

public class Service2 extends ServiceDecorator {

    public Service2(IService iService) {
        super(iService);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + VIP Service";
    }
}
