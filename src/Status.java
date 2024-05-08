import Exceptions.BadStatusException;

public enum Status {
    Green("Green"),
    Red("Red"),
    Yellow("Yellow");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    // String값을 받아서 상태enum에 맞는 케이스를 찾아주고 찾지 못하면 예외처리를 해주는 함수
    public static Status getStatusByString(String status) throws BadStatusException {
        for (Status s : Status.values()) {
            if (s.getStatus().equals(status)) {
                return s;
            }
        }
        // 맞지 않는 상태 입력시 예외처리
        throw new BadStatusException();
    }
}
