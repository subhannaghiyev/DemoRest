package az.spring.rest.springrestdemo.enums;

public enum ErrorCodeEnum {
    EMPLOYEE_NOT_FOUND(1000,"Can not found given id"),
    EMPLOYEE_BAD_REQUEST(400,"Bad Request in write");
    private final int code;
    private final String message;

    ErrorCodeEnum(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public int getCode(){
        return code;
    }

}
