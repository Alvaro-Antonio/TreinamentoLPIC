package com.usermanager.simulated;

import com.usermanager.simulated.jpa.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlternativeRepository extends JpaRepository<Alternative, Long> {
    Optional<Alternative> findAlternativeByIdAndQuestionIdAndQuestionUserCreateId(Long alternativeId, Long questionId, Long UserId);
    List<Alternative>  findAllByQuestionIdAndQuestionUserCreateId(Long questionId, Long UserId);

}
