package lesson7Homework;

//        Класс Pupil описывается с атрибутами:
//        id и результат экзаменов (массив) ExamResult[].
//
//        Класс ExamResult можно описать как в отдельном файле, так и внутренним классом. Вы создаете этот класс как внутренний (не статические member inner class).
//        ExamResult содержит следующие свойства:
//        название предмета,
//        оценка,
//        статус сдал/не сдал.
//
//        Именно класс ExamResult производит проверку сдал ученик экзамен или нет.
//
//        Использование программы:
//        Pupil pupil = new Pupil(1324);
//        String ex[] = {"Математика","Биология"};
//        int marks[] = { 2, 5 };
//        pupil.setExams(ex, marks);
//        System.out.println(pupil.toString());
//        Вывод:
//        Студент: 1324
//        Математика не сдал
//        Биология сдал

public class Main {
    public static void main(String[] args) {
        Pupil pupil = new Pupil(1324);
        String ex[] = {"Математика","Биология"};
        int marks[] = { 2, 5 };
        pupil.setExams(ex, marks);
        System.out.println(pupil.toString());
    }
}
