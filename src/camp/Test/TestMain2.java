package camp.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMain2 {
    public static void main(String[] args) {
        ArrayList<TestStudentClass> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("저장할 학생의 순번을 입력 : ");
        int numStudents = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("학생 이름 : ");
            String name = sc.nextLine();

            System.out.print("학생 ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("학생 과목 입력 (복수 가능) : ");
            String subjectsInput = sc.nextLine();
            String[] subjectsArray = subjectsInput.split(",");

            List<String> subjects = new ArrayList<>();
            for (String subject : subjectsArray) {
                subjects.add(subject.trim());
            }

            TestStudentClass student = new TestStudentClass(name, id, subjects);
            students.add(student);
        }

        System.out.println("\nStudent Information:");
        for (TestStudentClass student : students) {
            System.out.println(student);
        }
    }
}
