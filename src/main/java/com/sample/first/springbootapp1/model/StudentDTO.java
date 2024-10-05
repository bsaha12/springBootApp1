package com.sample.first.springbootapp1.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @Size(min = 3, max = 20, message = "Invalid Name")
    public String name;
    @Min(value = 50)
    public Integer marks;

}
