package ddp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

/**
 * Basic User entity.
 */
@Entity
@Getter
@Setter
@Table(indexes = @Index(columnList = "id"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private Integer age;

    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be greater than zero")
    private Double weight;

    @NotNull(message = "Height is required")
    @Positive(message = "Height must be greater than zero")
    private Double height;

    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

    private double recommendedCaloricIntake;
}