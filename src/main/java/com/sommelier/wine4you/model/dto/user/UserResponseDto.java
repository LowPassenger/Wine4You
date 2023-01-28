package com.sommelier.wine4you.model.dto.user;

import com.sommelier.wine4you.model.Address;
import com.sommelier.wine4you.model.Cart;
import com.sommelier.wine4you.model.Role;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthday;
    private String phone;
    private Address address;
    private Cart cart;
    private Set<Role> roles;
    private LocalDateTime registrationDate;
    private boolean isDeleted;

    @Override
    public String toString() {
        return "UserResponseDto{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", email='" + email + '\''
                + ", password='" + "OK" + '\''
                + ", birthday=" + birthday
                + ", phone='" + phone + '\''
                + ", address=" + address
                + ", cart=" + cart
                + ", roles=" + roles
                + ", registrationDate=" + registrationDate
                + ", isDeleted=" + isDeleted
                + '}';
    }
}