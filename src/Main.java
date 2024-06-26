import Exceptions.BadStatusException;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Subject> subjects = new ArrayList<>();
    public static void main(String[] args) throws BadStatusException, IOException {
        // 초기 설정
        subjects.add(new Subject(0, "Java", "필수"));
        subjects.add(new Subject(1, "객체지향", "필수"));
        subjects.add(new Subject(2, "Spring", "필수"));
        subjects.add(new Subject(3, "JPA", "필수"));
        subjects.add(new Subject(4, "MySQL", "필수"));

        subjects.add(new Subject(5, "디자인 패턴", "선택"));
        subjects.add(new Subject(6, "Spring Security", "선택"));
        subjects.add(new Subject(7, "Redis", "선택"));
        subjects.add(new Subject(8, "MongoDB", "선택"));


        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.start();
    }
}