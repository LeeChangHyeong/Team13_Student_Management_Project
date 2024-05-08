public class ScoreManager {
    public static void inquiryAverageGradeBySubject() {
        // 과목별 총 점수의 합을 저장할 배열
        int[] sum = new int[9];
        // 과목별 응시생 수를 저장할 배열
        int[] count = new int[9];

        for (Score s : ScoreRegistration.scoreEntries) {
            int subjectId = s.getSubjectId();
            // 과목별 총 점수의 합과 응시생 수 누적
            sum[subjectId] += s.getScore();
            count[subjectId]++;
        }

        System.out.println("------------------------------");
        System.out.println("과목별 평균 등급 조회");
        System.out.println("------------------------------");

        // 과목별 평균 등급 출력
        for (int i = 0; i < 9; i++) {
            int subjectId = i;
            if (count[i] == 0) {
                System.out.println("'" + Score.getSubjectNameToId(i) + "'을(를)" + " 응시한 수험생이 없습니다.");
            } else {
                int average = sum[i] / count[i];
                System.out.println("'" + Score.getSubjectNameToId(i) + "'의 평균 등급: " + Score.calculateGradeWithId(average, i));
            }
        }
    }
}