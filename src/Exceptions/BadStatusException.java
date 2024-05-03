package Exceptions;

// 수강생 상태 입력 예외처리
public class BadStatusException extends Exception{
    public BadStatusException() {
        super("상태를 잘못 입력하셨습니다.(Green, Yellow, Red 중 한 가지를 입력해주세요.)");
    }
}
