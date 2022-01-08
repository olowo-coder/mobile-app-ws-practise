package com.example.mobileappwspractise.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document("userDetails")
public class UserDetails {
    @Id
    private String userId;

    @NotNull(message = "first Name cannot be null")
    @Size(min = 2, message = "first Name must not be less than 2")
    private String firstName;

    @NotNull(message = "last Name cannot be null")
    @Size(min = 2, message = "last Name must not be less than 2")
    private String lastName;

    @NotNull(message = "email cannot be null")
    @Email
    private String email;

    @NotNull(message = "password cannot be null")
    @Size(min = 8, max = 16, message = "Password must not be less than eight character and not more than 16")
    private String password;

}
