package com.sommelier.wine4you.model.dto;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserSignUpDto {
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, message = "First name should have at least 3 characters")
    @Size(max = 20, message = "The first name must contain no more than 20 characters")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, message = "Last name should have at least 3 characters")
    @Size(max = 40, message = "The last name must contain no more than 40 characters")
    private String lastName;

    @Email
    @Size(min = 5, message = "Email should have at least 5 characters")
    private String email;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password should have at least 8 characters")
    @Size(max = 30, message = "The password must contain no more than 30 characters")
    private String password;
    @NotBlank(message = "Birthday is mandatory")
    private LocalDate birthday;
    @NotBlank(message = "Phone is mandatory")
    private String phone;
    @NotBlank(message = "Address is mandatory")
    @Size(max = 40, message = "The address must contain no more than 40 characters")
    private String address;
    @NotBlank(message = "City is mandatory")
    @Size(max = 40, message = "The city must contain no more than 40 characters")
    private String city;
}
