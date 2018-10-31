package lesson7.nested;

public class OuterClass {
    static int intVar=1;
    String value;

    public OuterClass(String value) {
        this.value = value;
    }

    public InnerClass getInner() {
        return new InnerClass("Объект внутреннего класса");
    }

    static class InnerClass {
        String val;

        public InnerClass(String val) {
            this.val = val;
        }

        public void someVoid(){
            intVar +=12;
            System.out.println(intVar);
//            System.out.println(value);  - ошибка, не имеет доступа к нестатическим методам внешнего класса
        }
    }
}
