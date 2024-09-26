package dev.waiyanhtet.springcloudconfigclient.aop;

import dev.waiyanhtet.springcloudconfigclient.annotation.FeatureToggle;
import dev.waiyanhtet.springcloudconfigclient.config.GreetPropertiesConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class FeatureToggleAspect {

    private final GreetPropertiesConfig greetPropertiesConfig;

    @Around("@annotation(featureToggle)")
    public Object toggleFeature(ProceedingJoinPoint joinPoint, FeatureToggle featureToggle) throws Throwable {
        String featureName = featureToggle.value();

        if (isFeatureDisabled(featureName)) {
            return handleFeatureDisabled(featureName);
        }

        return joinPoint.proceed();
    }

    private boolean isFeatureDisabled(String featureName) {
        var disabledFeatures = greetPropertiesConfig.getDisabledFeatures();
        Set<String> disabledFeatureSet = new HashSet<>();
        for (String feature : disabledFeatures.split(",")) {
            disabledFeatureSet.add(feature.trim());
        }
        return disabledFeatureSet.contains(featureName);
    }

    private Object handleFeatureDisabled(String featureName) {
        log.info("Feature {} is disabled.", featureName);
        return new Object();
    }
}
