package dev.waiyanhtet.springcloudconfigclient.service;

import dev.waiyanhtet.springcloudconfigclient.dto.request.RegisterRequest;
import dev.waiyanhtet.springcloudconfigclient.dto.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final NotificationService notificationService;

    public RegisterResponse register(RegisterRequest request) {
        // register to db
        var response = RegisterResponse.builder()
                .registrationId("1")
                .name(request.getName())
                .email(request.getEmail())
                .build();

        notificationService.sendNotification(request);
        log.info("Registration is successful: {}", response.toString());
        return response;
    }
}