package com.usermanager.indicators.services;

import com.usermanager.indicators.jpa.Indicators;

@FunctionalInterface
public interface GetIndicatorsService {
    Indicators getIndicators(Long userId);
}
