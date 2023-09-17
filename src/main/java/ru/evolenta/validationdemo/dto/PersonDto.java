package ru.evolenta.validationdemo.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    @NotNull(message = "Имя обязательно для заполнения")
    @NotEmpty(message = "Имя обязательно для заполнения")
    private String name;

    @NotNull(message = "Возраст обязателен для заполнения")
    @Min(value = 18, message = "Минимальный возраст 18")
    private Integer age;
}
