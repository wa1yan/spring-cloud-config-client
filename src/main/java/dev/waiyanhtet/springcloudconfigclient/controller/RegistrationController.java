package dev.waiyanhtet.springcloudconfigclient.controller;

import dev.waiyanhtet.springcloudconfigclient.dto.request.RegisterRequest;
import dev.waiyanhtet.springcloudconfigclient.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<?> greet(@RequestBody RegisterRequest registerRequest) {
        var response = registrationService.register(registerRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
