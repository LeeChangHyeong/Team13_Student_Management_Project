import java.util.*;

public class UpdateScore {


    private Scanner sc;
    private ArrayList<Score> scoreList;
    private ArrayList<Score> findByStudentIdScoreList = new ArrayList<>();;

    private ArrayList<Score> findByRoundScoreList = new ArrayList<>();;
    private Score findBySubjetcScore;

    public UpdateScore(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
        this.sc = new Scanner(System.in);
    }
    public void update(){
        String studentId = "";
        int roundToUpdate = 0;
        String subjectToUpdate = "";
        boolean studentFound = false;
        int ScoreToUpdate = 0;

        Set<String> validSubjects = new HashSet<>();
        validSubjects.add("java");
        validSubjects.add("객체지향");
        validSubjects.add("spring");
        validSubjects.add("jpa");
        validSubjects.add("mysql");
        validSubjects.add("디자인패턴");
        validSubjects.add("spring security");
        validSubjects.add("redis");
        validSubjects.add("mongoDb");


        while(!studentFound){
            System.out.println("변경할 수강생 ID를 입력하세요.");
            studentId = sc.next();

            for(Score score : scoreList){
                if(score.getStudentId().equals(studentId)){
                    findByStudentIdScoreList.add(score);
                    studentFound = true;
                }
            }
            if(!studentFound){
                System.out.println("해당 ID의 수강생이 존재하지 않습니다.");
                System.out.println("다시 입력해주세요.");
            }
        }
        System.out.println("변경할 성적 리스트");
        System.out.println("--------------------------------------------");
        for(Score score : findByStudentIdScoreList){
            System.out.println("학생 아이디 : "+score.getStudentId());
            System.out.println("성적 아이디 : "+score.getScoreId());
            System.out.println("성적 회차 : "+score.getRound());
            System.out.println("성적 과목 : "+score.getSubject());
            System.out.println("점수 : "+score.getScore());
            System.out.println("등급 : "+score.getGrade());
            System.out.println("--------------------------------------------");
        }

        boolean validRound = false;
        while (!validRound) {
            System.out.println("변경할 성적 회차를 입력해주세요. (1~10 사이)");
            try {
                roundToUpdate = sc.nextInt(); // 정수 입력 받음
                // 점수가 1과 10 사이인지 확인
                if (roundToUpdate > 0 && roundToUpdate <= 10) {
                    for(Score score : findByStudentIdScoreList){
                        if(score.getRound()==roundToUpdate){
                            findByRoundScoreList.add(score);
                        }
                    }
                    validRound = true;

                } else {
                    System.out.println("회차는 1에서 10 사이여야 합니다. 다시 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 입력입니다. 숫자를 입력해주세요.");
                sc.nextInt();
            }
        }

        boolean validSubject = false;
        while (!validSubject) {
            System.out.println("변경할 성적 과목을 입력해주세요.");
            try {
                subjectToUpdate = sc.next();

                if (validSubjects.contains(subjectToUpdate)) {
                    for(Score score : findByStudentIdScoreList){
                        if(score.getSubject().equals(subjectToUpdate)){
                            findBySubjetcScore = score;
                        }
                    }
                    validSubject = true;
                } else {
                    System.out.println("입력 가능한 과목 리스트");
                    for (String subject : validSubjects) {
                        System.out.println(subject);
                    }
                    System.out.println("다시 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 입력입니다. 숫자를 입력해주세요.");
                sc.next();
            }
        }


        boolean validScore = false;
        while (!validScore) {
            System.out.println("변경할 점수를 입력해주세요. (0~100 사이)");
            try {
                ScoreToUpdate = sc.nextInt(); // 정수 입력 받음
                // 점수가 0과 100 사이인지 확인
                if (ScoreToUpdate >= 0 && ScoreToUpdate <= 100) {
                    validScore = true;
                } else {
                    System.out.println("점수는 0에서 100 사이여야 합니다. 다시 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("유효하지 않은 입력입니다. 숫자를 입력해주세요.");
                sc.next();
            }
        }
        findBySubjetcScore.setScore(ScoreToUpdate);
        //------------------------------------------------------------
        //------------------------------------------------------------
        //------------------------------------------------------------
        //점수에 따라서 등급 산정해서 setGrade하는 로직이 와야함
        //------------------------------------------------------------
        //------------------------------------------------------------
        //------------------------------------------------------------
        System.out.println("변경을 완료했습니다.");
        for (Score score : scoreList) {
            if (score.getStudentId().equals(studentId) && score.getRound() == roundToUpdate && score.getSubject().equals(subjectToUpdate)) {
                System.out.println("--------------------------------------------");
                System.out.println("학생 아이디 : " + score.getStudentId());
                System.out.println("성적 아이디 : " + score.getScoreId());
                System.out.println("성적 회차 : " + score.getRound());
                System.out.println("성적 과목 : " + score.getSubject());
                System.out.println("점수 : " + score.getScore());
                System.out.println("등급 : " + score.getGrade());
                System.out.println("--------------------------------------------");
                break; //
            }
        }



    }
}


