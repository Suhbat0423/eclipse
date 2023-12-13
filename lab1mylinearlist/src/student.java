import dataStructures.Chain;

public class student {
    private String studentCode;
    private Major studentMajor;
    private float GPA;
    private Chain lessons;

    public student() {
        studentCode = null;
        studentMajor = null;
        lessons = new Chain();
    }

    public student(String sCode, Major smajor) {
        studentCode = sCode;
        studentMajor = new Major(smajor);
        lessons = new Chain();
    }

    public String getCode() {
        return studentCode;
    }

    public float getGPA() {
        float sumCredit = 0;
        float sumGrade = 0;

        for (int i = 0; i < lessons.size(); i++) {
            Lesson currentLesson = (Lesson) lessons.get(i);
            sumCredit += currentLesson.getLearned().getCredit();
            sumGrade += currentLesson.getGrade() * currentLesson.getLearned().getCredit();
        }

        GPA = (sumCredit != 0) ? sumGrade / sumCredit : 0;
        return GPA;
    }

    public Major getMajor() {
        return studentMajor;
    }

    public void addLesson(Subject l, int sc) {
        Lesson al = new Lesson(l, sc);
        if (lessons.indexOf(al) == -1)
            lessons.add(lessons.size(), al);
    }

    public boolean hasFailed() {
        int failCountThreshold = 3;
        int failCount = 0;

        for (int i = 0; i < lessons.size(); i++) {
            Lesson currentLesson = (Lesson) lessons.get(i);
            if (currentLesson.getGrade() <= 1.0f) {
                failCount++;
                if (failCount >= failCountThreshold) {
                    System.out.println("Student code " + getCode() + " has failed.");
                    return true;
                }
            }
        }
        return false;
    }

    public static void displayHeader() {
        String titleTemplate = "%-20s %10s %10s\n";
        System.out.println("*****oyutnuudiin golch onoonii jagsaalt *****");
        System.out.printf(titleTemplate, "Student code", "uzsen too/", "golch onoo");
    }

    public void displayGpa() {
        String titleTemplate = "%-20s %10s %10.2f\n";
        System.out.printf(titleTemplate, getCode(), lessons.size(), getGPA());
    }
}
