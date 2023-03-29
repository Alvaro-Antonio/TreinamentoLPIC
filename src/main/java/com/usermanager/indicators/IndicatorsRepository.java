package com.usermanager.indicators;

import com.usermanager.indicators.jpa.Indicators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorsRepository extends JpaRepository<Indicators, Long> {

    Indicators findByUserId(Long userId);
}
