package com.usermanager.simulated;

import com.usermanager.simulated.jpa.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "select * from Question order by random() limit ?1 ",nativeQuery = true)
    List<Question> findAllRandonAndLimited(int amount);

    void deleteById(Long questionId);
}
