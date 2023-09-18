package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @PostMapping("/addQuiz")
    public ResponseEntity<Quiz> addQuiz(@RequestParam int num , @RequestParam String title , @RequestParam String category ){
        return quizService.addQuiz(num,title,category);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Optional<Quiz>> getQuizById(@PathVariable Integer quizId){
        return quizService.getQuizById(quizId);
    }

    // get quiz with title
}
