import java.util.*;

// 점수 등록을 위한 ScoreEntry 클래스 정의
class Score {
    private int id; // 수강생 고유 번호
    private String subject; // 과목명
    private int round;      // 회차
    private int score;      // 점수
    private String grade;   // 등급

    // 생성자: 과목명, 회차, 점수를 받아서 객체를 초기화함
    public Score(int id, String subject, int round, int score) {
        this.id = id;
        this.subject = subject;
        this.round = round;
        this.score = score;
        this.grade = calculateGrade(score); // 점수에 따라 등급을 계산하여 설정함
    }

    // 과목명 getter
    public String getSubject() {
        return subject;
    }

    // 회차 getter
    public int getRound() {
        return round;
    }

    // 점수 getter
    public int getScore() {
        return score;
    }

    // 등급 getter
    public String getGrade() {
        return grade;
    }

    // 점수를 기준으로 등급을 계산하는 메서드
    private String calculateGrade(int score) {
        if (subject.equals("자바")) {           //나중에 과목이름으로 변경
            if (score >= 95) {
                return "A";
            } else if (score >= 90) {
                return "B";
            } else if (score >= 80) {
                return "C";
            } else if (score >= 70) {
                return "D";
            } else if (score >= 60) {
                return "F";
            } else {
                return "N";
            }
        } else if (subject.equals("디자인 패턴")) {      //else로 바꿔도 됨
            if (score >= 90) {
                return "A";
            } else if (score >= 80) {
                return "B";
            } else if (score >= 70) {
                return "C";
            } else if (score >= 60) {
                return "D";
            } else if (score >= 50) {
                return "F";
            } else {
                return "N";
            }
        }
        return "";
    }
}