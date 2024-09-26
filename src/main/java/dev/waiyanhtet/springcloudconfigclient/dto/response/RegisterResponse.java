package dev.waiyanhtet.springcloudconfigclient.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {

    private String registrationId;
    private String name;
    private String email;
}
