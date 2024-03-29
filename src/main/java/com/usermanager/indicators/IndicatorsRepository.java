package com.usermanager.indicators;

import com.usermanager.indicators.jpa.Indicators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicatorsRepository extends JpaRepository<Indicators, Long> {

    Indicators findByUserId(Long userId);

    @Query(value = "select * from indicators order by score desc limit 10",nativeQuery = true)
    List<Indicators> findAllByOrderByScoreDesc();
}
