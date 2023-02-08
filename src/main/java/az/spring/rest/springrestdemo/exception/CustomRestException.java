package az.spring.rest.springrestdemo.exception;

import az.spring.rest.springrestdemo.enums.ErrorCodeEnum;

public class CustomRestException extends RuntimeException {

    private final int code;
    private final String message;

    public CustomRestException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = (errorCodeEnum.getCode());
        this.message = errorCodeEnum.getMessage();

    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
