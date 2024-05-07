import java.util.*;

public class scoreRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Score> scoreEntries = new ArrayList<>(); // 저장할 리스트 생성

        // 사용자가 종료를 입력할 때까지 반복
        while (true) {
            System.out.println("과목을 입력하세요 (종료하려면 '종료' 입력): ");
            String subject = scanner.nextLine();
            if (subject.equals("종료")) {
                break; // 사용자가 종료를 입력하면 반복문 종료
            }

            System.out.println("회차를 입력하세요 (1 ~ 10 사이의 숫자): ");
            int round = Integer.parseInt(scanner.nextLine());
            if (round < 1 || round > 10) {
                System.out.println("오류: 회차는 1부터 10 사이의 숫자여야 합니다.");
                continue; // 잘못된 입력이면 반복문의 처음으로 돌아감
            }

            System.out.println("점수를 입력하세요 (0 ~ 100 사이의 숫자): ");
            int score = Integer.parseInt(scanner.nextLine());
            if (score < 0 || score > 100) {
                System.out.println("오류: 점수는 0부터 100 사이의 숫자여야 합니다.");
                continue; // 잘못된 입력이면 반복문의 처음으로 돌아감
            }

            // 이미 등록된 회차인지 확인
            boolean isDuplicate = false;
            for (Score entry : scoreEntries) {
                if (entry.getSubject().equals(subject) && entry.getRound() == round) {
                    System.out.println("오류: 이미 등록된 회차입니다.");
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                continue; // 이미 등록된 회차이면 반복문의 처음으로 돌아감
            }

            // 새로운 Score 객체 생성 및 리스트에 추가
            Score newEntry = new Score(subject, round, score);
            scoreEntries.add(newEntry);

            // 사용자에게 성공적으로 등록되었음을 알림
            System.out.println("회차 " + round + "의 점수가 성공적으로 등록되었습니다. (등급: " + newEntry.getGrade() + ")");
        }
        //반복문으로 되돌아감

        System.out.println("프로그램을 종료합니다."); // 사용자가 종료를 입력하면 이 메시지가 출력됨
        scanner.close();
    }
}