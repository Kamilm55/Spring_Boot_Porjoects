package com.example.quizapp.controller;

import com.example.quizapp.model.AnswerDTO;
import com.example.quizapp.model.QuestionDto;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<QuestionDto>> getQuizById(@PathVariable Integer quizId){
        return quizService.getQuizById(quizId);
    }

    @GetMapping("/title/{quizTitle}")
    public ResponseEntity<List<QuestionDto>> getQuizByTitle(@PathVariable String quizTitle){
        return quizService.getQuizByTitle(quizTitle);
    }

    @PostMapping("/check-by-question/{quizId}")
    public ResponseEntity<Boolean> checkAnswer(@PathVariable Integer quizId , @RequestParam Integer questionId , @RequestParam String userAnswer){
        return quizService.checkAnswer(quizId,questionId,userAnswer);
    }

    // overload this methods and check more quiz questions => List
    @PostMapping("/check-by-quiz/{quizId}")
    public ResponseEntity<List<Boolean>> checkAnswer( @PathVariable Integer quizId, @RequestBody List<AnswerDTO> answerDTOList){
        return quizService.checkAnswer(quizId , answerDTOList);
    }
}
