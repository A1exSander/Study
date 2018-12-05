package lesson17.patterns.factory;

abstract class Handler {
    abstract void read();
    abstract void write();

}

class TxtHandler extends Handler{
    @Override
    void read() {
        System.out.println("Read from txt");
    }

    @Override
    void write() {
        System.out.println("Write to txt");

    }
}

class XmlHandler extends Handler{
    @Override
    void read() {
        System.out.println("Read from xml");
    }

    @Override
    void write() {
        System.out.println("Write to xml");

    }
}

public class Factory {

    public static void main(String[] args) {
        Factory factory = new Factory();
        String file = "qwe.xml";
        factory.getHandler(file).read(); // орочий вариант. Лучше создать объект типа Handler = factory.getHandler(path);
    }

    public Handler getHandler(String path){
        Handler handler = null;
        if (path.endsWith("txt")){
            handler = new TxtHandler();
        } else if (path.endsWith("xml")){
            handler = new XmlHandler();
        }
        return handler;
    }

}
