
public class Score2 {
    private String subject; // 과목명
    private int round;      // 회차
    private int score;      // 점수
    private String grade;   // 등급
    private String studentId;
    private String ScoreId;

    public Score2(String subject, int round, int score, String grade, String studentId, String scoreId) {
        this.subject = subject;
        this.round = round;
        this.score = score;
        this.grade = grade;
        this.studentId = studentId;
        ScoreId = scoreId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getScoreId() {
        return ScoreId;
    }

    public void setScoreId(String scoreId) {
        ScoreId = scoreId;
    }
}
