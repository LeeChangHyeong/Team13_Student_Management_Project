package camp.Test;

import java.util.Scanner;
// 배열 여러개를 만들어서 각각 요소들을 배치한 로직.
// 같은 자리의 인덱스끼리는 모두 같은 학생의 정보를 가지고 있다.
public class Main {
    public static void main(String[] args) {
        TestClass tClass = new TestClass();
        Scanner sc = new Scanner(System.in);

        System.out.print("등록할 학생명 입력 : ");
        String name = sc.next();
        tClass.addStudentName(name);

        System.out.print("등록할 학생의 고유번호 입력 : ");
        int id = sc.nextInt();
        tClass.addStudentId(id);

        System.out.print("등록할 학생의 과목명 입력 : ");
        String subject = sc.next();
        tClass.addStudentSubject(subject);

        System.out.println("저장된 학생의 이름 : " + tClass.getStudentName());
        System.out.println("저장된 학생의 고유번호 : " + tClass.getStudentId());
        System.out.println("저장된 학생의 과목명 : " + tClass.getStudentSubject());
    }
}
