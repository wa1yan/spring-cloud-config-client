package dev.waiyanhtet.springcloudconfigclient.service;

import dev.waiyanhtet.springcloudconfigclient.annotation.FeatureToggle;
import dev.waiyanhtet.springcloudconfigclient.dto.request.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    @FeatureToggle("feature-notification")
    public void sendNotification(RegisterRequest request) {
       log.info("Sending notification for {} is successful.", request.getEmail());
    }
}
