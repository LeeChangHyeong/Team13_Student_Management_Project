package asd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import asd.ScoreRegistration;
public class GradeSearch {
    // 과목별 등급을 계산하는 메소드
    public static String calculateGrade(int score, String type) {
        if (type.equals("필수")) {
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
        } else if (type.equals("선택")) {
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

    public  void comparison(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 과목 리스트 생성
        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(0, "Java", "필수"));
        subjects.add(new Subject(1, "객체지향", "필수"));
        subjects.add(new Subject(2, "Spring", "필수"));
        subjects.add(new Subject(3, "JPA", "필수"));
        subjects.add(new Subject(4, "MySQL", "필수"));
        subjects.add(new Subject(5, "디자인 패턴", "선택"));
        subjects.add(new Subject(6, "Spring Security", "선택"));
        subjects.add(new Subject(7, "Redis", "선택"));
        subjects.add(new Subject(8, "MongoDB", "선택"));

        // 사용자로부터 과목명 입력 받기
        System.out.print("조회할 과목명을 입력하세요: ");
        String subjectName = br.readLine();

        // 입력받은 과목명과 일치하는 과목 찾기
        Subject selectedSubject = null;
        for (Subject subject : subjects) {
            if (subject.getName().equalsIgnoreCase(subjectName)) {
                selectedSubject = subject;
                break;
            }
        }

        // 해당 과목이 없는 경우 메시지 출력 후 종료
        if (selectedSubject == null) {
            System.out.println("해당 과목이 존재하지 않습니다.");
            return;
        }

        // 과목의 등급 계산

        //String grade = calculateGrade(score, selectedSubject.getType());

        // 결과 출력
        System.out.println("과목명: " + selectedSubject.getName());
        //System.out.println("등급: " + grade);
    }
}
