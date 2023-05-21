package com.shg.bmapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginInfoDTO {
        Integer id;
        String login;
        String firstName;
        String salutation;
        String lastName;
        String email;
        String orgUnitName;
        String language;
        String rights;
        String vdbGroupName;
        RolesDTO roles;
        Integer organizationalUnitId;
}
