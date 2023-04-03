package com.usermanager.indicators.services;

import com.usermanager.indicators.jpa.Indicators;

import java.util.List;

@FunctionalInterface
public interface GetRakingScoreService {
    List<Indicators> getRankingIndicators(Long userId);
}
