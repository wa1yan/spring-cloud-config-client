package dev.waiyanhtet.springcloudconfigclient.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;


@Getter
@AllArgsConstructor
public enum FeatureEnableConstant {

    FEATURE_A("feature-a"),
    FEATURE_B("feature-b"),
    FEATURE_C("feature-c"),
    FEATURE_D("feature-d"),
    FEATURE_E("feature-e"),
    FEATURE_F("feature-f");

    public final String featureName;

    public static List<String> getFeatureNameList() {
        return Arrays.stream(FeatureEnableConstant.values())
                .map(FeatureEnableConstant::getFeatureName)
                .toList();
    }
}
