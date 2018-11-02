package Lesson7Homework;

public class Pupil {
    ExamResult[] examResults = new ExamResult[2];
    private int id;
    public Pupil(int id) {
        this.id = id;
    }

    void setExams(String exams[], int marks[]) {
        if (exams.length == marks.length) {
            for (int i = 0; i<exams.length; i++){
                if (marks[i]>0 && marks[i]<6) {
                    examResults[i] = new ExamResult(exams[i], marks[i]);
                } else System.out.println("Ошибка! Оценки должны указываться цифрой от 1 до 5");

            }
        } else System.out.println("Ошибка! Количество оценок не соответствует количеству предметов. Проверьте исходные данные");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<examResults.length; i++){
            stringBuilder.append("\n");
            stringBuilder.append(examResults[i].toString());
        }
        return "Студент: " + id + stringBuilder.toString();
    }

    private class ExamResult {
        Boolean status;
        String exam;
        int mark;

        public ExamResult(String exam, int mark) {
            this.status = mark > 2;
            this.exam = exam;
            this.mark = mark;
        }

        @Override
        public String toString() {
            if (status == true) return exam + " сдал";
            else return exam + " не сдал";
        }
    }
}
