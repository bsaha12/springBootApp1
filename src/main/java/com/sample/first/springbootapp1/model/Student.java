package com.sample.first.springbootapp1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roll;
    @Min(value = 50 , message = "{marks.invalid}")
    @Max(value = 100 , message = "Marks should be less than 100")
    private Integer marks ;
    @NotNull(message = "Name is mandatory")
    @Size(min = 3 , max = 12 , message = "Name size Invalid")
    private String name;
    private String course;
}
