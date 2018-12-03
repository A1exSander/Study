package lesson14;

public class ExceptionExample {
    public static void main(String[] args) throws Exception {
        // выбросить свое испключение
//        throw new NumberFormatException("NFE");
        // обработака исключений

//        try-catch
        Object data = "42";
//        Integer intData = (Integer) data; // ClassCastException
        try {
            Integer intData = (Integer) data; // ClassCastException
            System.out.println("code after ClassCastException");
        }
//        catch (ClassCastException e) {
//            System.out.println("exception: " + e.getMessage());
//        }
//        catch (RuntimeException e) {
//            System.out.println("exception: " + e.getMessage());
//        }
        catch (ClassCastException | NullPointerException e) {
            System.out.println("gotcha!");
        } finally {
            System.out.println("finally");
        }
        System.out.println("code after all");


        // checked excetion
//        try {
//            throw new ExceptionExample("checked xception");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try{
//            voidWithException();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        throw new CheckedException("");
        try {
            voidWithCheckedException();
        }
        catch (CheckedException e){
            e.printStackTrace();
            throw new UncheckedException("In catch");
        }
    }

    private static void voidWithException() throws Exception {
        throw new Exception("Checked exception");
    }
    private static void voidWithCheckedException() throws CheckedException {
        throw new CheckedException("Checked exception");
    }

}

