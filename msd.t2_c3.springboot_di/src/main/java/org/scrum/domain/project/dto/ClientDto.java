package org.scrum.domain.project.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String avatar;
    private String phone;
    private String role;
    private String address;
}
