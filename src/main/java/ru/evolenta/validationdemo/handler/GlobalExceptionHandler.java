package ru.evolenta.validationdemo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.evolenta.validationdemo.dto.FieldValidationErrorDto;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<List<FieldValidationErrorDto>> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        List<FieldValidationErrorDto> errors = exception.getFieldErrors().stream()
                .map(error -> new FieldValidationErrorDto(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
