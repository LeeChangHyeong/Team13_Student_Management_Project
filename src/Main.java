import Exceptions.BadStatusException;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Subject> subjects = new ArrayList<>();


    public static void main(String[] args) throws BadStatusException, IOException {
        // 초기 설정
        subjects.add(new Subject(11, "Java", "필수"));
        subjects.add(new Subject(12, "객체지향", "필수"));
        subjects.add(new Subject(13, "Spring", "필수"));
        subjects.add(new Subject(14, "JPA", "필수"));
        subjects.add(new Subject(15, "MySQL", "필수"));

        subjects.add(new Subject(21, "디자인 패턴", "선택"));
        subjects.add(new Subject(22, "Spring Security", "선택"));
        subjects.add(new Subject(23, "Redis", "선택"));
        subjects.add(new Subject(24, "MongoDB", "선택"));


        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.start();
    }
}