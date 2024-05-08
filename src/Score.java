// 점수 등록을 위한 ScoreEntry 클래스 정의
class Score {
    private int subjectId; // 과목 고유 번호
    private int id; // 수강생 고유 번호
    private int round;      // 회차
    private int score;      // 점수
    private String grade;   // 등급

    // 생성자: 과목명, 회차, 점수를 받아서 객체를 초기화함
    public Score(int subjectId, int id, int round, int score) {
        this.subjectId = subjectId;
        this.id = id;
        this.round = round;
        this.score = score;
        this.grade = calculateGrade(score); // 점수에 따라 등급을 계산하여 설정함
    }

    // 과목 아이디로 과목명 가져오는 함수
    static public String getSubjectNameToId(int subjectId) {
        String str = "";
        for (Subject s : Main.subjects) {
            if (subjectId == s.getId()) {
                str = s.getName();
                break;
            }
        }
        return str;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public int getStudentId() {
        return this.id;
    }

    // 과목명 getter
    public String getSubjectName() {
        String str = "";
        for (Subject s : Main.subjects) {
            if (subjectId == s.getId()) {
                str = s.getName();
                break;
            }
        }
        return str;
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
        String type = "";

        for (Subject s : Main.subjects) {
            if (s.getId() == subjectId) {
                type = s.getType();
                break;
            }
        }

        return divideGrade(type);
    }

    private String divideGrade(String type) {
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
        } else if (type.equals("선택")) {      //else로 바꿔도 됨
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

    // 현재 선택한 Score의 과목 타입을 알 수 있는 메서드
    public String getType() {
        String type = "";
        for (Subject s : Main.subjects) {
            if (s.getId() == subjectId) {
                type = s.getType();
                break;
            }
        }
        return type;
    }

    // 과목 id를 가지고 과목 타입을 찾을 수 있는 메서드
    public static String getTypeById(int id) {
        String type = "";
        for (Subject s : Main.subjects) {
            if (s.getId() == id) {
                type = s.getType();
                break;
            }
        }
        return type;
    }

    public static String calculateGradeWithId(int score, int id) {
        String type = "";

        type = getTypeById(id);

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
        } else if (type.equals("선택")) {      //else로 바꿔도 됨
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