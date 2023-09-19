package com.example.quizapp.dao;

import com.example.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

    Optional<Quiz> findQuizByTitle(String quizTitle);

    boolean existsQuizByTitle(String title);
}
