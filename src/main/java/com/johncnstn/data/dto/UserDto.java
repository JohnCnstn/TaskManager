package com.johncnstn.data.dto;

import com.johncnstn.validation.PasswordMatches;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    @Min(4)
    @Max(10)
    @Setter
    @Getter
    private String userName;

    @NotNull
    @NotEmpty
    @Min(2)
    @Max(20)
    @Setter
    @Getter
    private String firstName;

    @NotNull
    @NotEmpty
    @Min(2)
    @Max(20)
    @Setter
    @Getter
    private String lastName;

    @NotNull
    @NotEmpty
    @Min(4)
    @Max(20)
    @Setter
    @Getter
    private String password;

    @Setter
    @Getter
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @Email
    @Setter
    @Getter
    private String email;
}
