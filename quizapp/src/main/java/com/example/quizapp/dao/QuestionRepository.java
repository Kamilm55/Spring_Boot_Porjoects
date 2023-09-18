package com.example.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.quizapp.model.Question;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByCategory(String category);
    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :num" , nativeQuery = true)
    List<Question> findRandomQuestions(int num, String category);
}
