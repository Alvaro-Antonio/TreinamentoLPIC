package com.usermanager.simulated;

import com.usermanager.simulated.jpa.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternativeRepository extends JpaRepository<Alternative, Long> {
}