public class Lesson {
    public Subject learned;
    public int score;

    public Lesson(Subject l, int sc) {
        learned = new Subject(l);
        score = sc;
    }

    public float getGrade() {
        switch (score / 10) {
            case 10:
            case 9:
                return 4.0f;
            case 8:
                return 3.7f;
            case 7:
                return 3.4f;
            case 6:
                return 3.0f;
            case 5:
                return 2.7f;
            case 4:
                return 2.4f;
            case 3:
                return 2.0f;
            case 2:
                return 1.7f;
            case 1:
                return 1.3f;
            case 0:
                return 1.0f;
            default:
                return 0.0f;
        }
    }

    public Subject getLearned() {
        return learned;
    }

    public int getScore() {
        return score;
    }
}
