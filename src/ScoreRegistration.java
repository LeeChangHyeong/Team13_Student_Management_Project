import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ScoreRegistration {
        static ArrayList<Score2> scoreEntries = new ArrayList<>(); // 저장할 리스트 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void setScore() throws IOException {
        // 사용자가 종료를 입력할 때까지 반복
        A: while (true) {
            System.out.print("성적을 등록할 수강생의 고유 번호 입력: ");
            int id = Integer.parseInt(br.readLine());

            for(Subject s: Main.subjects) {
                System.out.println("과목 고유번호: " + s.getId() +", 과목 이름: " + s.getName() + ", 과목 타입: " + s.getType());
            }

            System.out.print("과목 고유 번호 입력: ");
            int subjectId = Integer.parseInt(br.readLine());


            System.out.println("회차를 입력하세요 (1 ~ 10 사이의 숫자): ");
            int round = Integer.parseInt(br.readLine());
            if (round < 1 || round > 10) {
                System.out.println("오류: 회차는 1부터 10 사이의 숫자여야 합니다.");
                continue; // 잘못된 입력이면 반복문의 처음으로 돌아감
            }

            System.out.println("점수를 입력하세요 (0 ~ 100 사이의 숫자): ");
            int score = Integer.parseInt(br.readLine());
            if (score < 0 || score > 100) {
                System.out.println("오류: 점수는 0부터 100 사이의 숫자여야 합니다.");
                continue; // 잘못된 입력이면 반복문의 처음으로 돌아감
            }

            // 이미 등록된 회차인지 확인
            boolean isDuplicate = false;
            for (Score2 entry : scoreEntries) {
                if (entry.getSubjectName() == entry.getSubjectNameToId(subjectId) && entry.getRound() == round) {
                    System.out.println("오류: 이미 등록된 회차입니다.");
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                continue; // 이미 등록된 회차이면 반복문의 처음으로 돌아감
            }

            // 새로운 Score 객체 생성 및 리스트에 추가
            Score2 newEntry = new Score2(subjectId, id, round, score);
            scoreEntries.add(newEntry);

            // 사용자에게 성공적으로 등록되었음을 알림
            System.out.println("회차 " + round + "의 점수가 성공적으로 등록되었습니다. (등급: " + newEntry.getGrade() + ")");

            while (true) {
                System.out.print("성적을 더 추가하시겠습니까? (1. 예, 2. 아니오) ");
                String str = br.readLine();
                if("1".equals(str)) {
                    break;
                } else {
                    break A;
                }
            }
        }
        //반복문으로 되돌아감
    }

}