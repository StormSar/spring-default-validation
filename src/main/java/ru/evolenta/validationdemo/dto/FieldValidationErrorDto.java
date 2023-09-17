package ru.evolenta.validationdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldValidationErrorDto {
    private final String filed;
    private final String message;
}
