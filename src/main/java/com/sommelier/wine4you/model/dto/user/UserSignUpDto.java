package com.sommelier.wine4you.model.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sommelier.wine4you.model.dto.address.AddressRequestDto;
import com.sommelier.wine4you.utils.Email;
import com.sommelier.wine4you.utils.Phone;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthday;

    @NotBlank(message = "Phone is mandatory")
    @Phone(message = "The phone must match the mask +XX-XXX-XXX-XXXX")
    private String phone;
    private AddressRequestDto address;

    @Override
    public String toString() {
        return "UserSignUpDto{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", email='" + email + '\''
                + ", password='" + "OK" + '\''
                + ", birthday=" + birthday
                + ", phone='" + phone + '\''
                + ", address=" + address
                + '}';
    }
}
