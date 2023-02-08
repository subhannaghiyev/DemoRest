package az.spring.rest.springrestdemo.advice;

import az.spring.rest.springrestdemo.enums.ErrorCodeEnum;
import az.spring.rest.springrestdemo.exception.CustomRestException;
import az.spring.rest.springrestdemo.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(CustomRestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleException(CustomRestException e) {
        return ErrorResponse.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNumberException() {
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.EMPLOYEE_BAD_REQUEST.getCode())
                .message(ErrorCodeEnum.EMPLOYEE_BAD_REQUEST.getMessage())
                .build();
    }
}
