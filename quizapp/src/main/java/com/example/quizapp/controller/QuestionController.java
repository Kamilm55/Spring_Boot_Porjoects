package com.example.quizapp.controller;

import com.example.quizapp.service.QuestionService;
import com.example.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getAllQuestionsByCategory(category);
    }

    @PostMapping("/addQuestion")
    public void addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
    }

    @PostMapping("/addMoreQuestions")
    public void addQuestionsList(@RequestBody List<Question> questionList){
        questionService.addQuestionsList(questionList);
    }

    @DeleteMapping("/deleteQuestion")
    public ResponseEntity<String> deleteOneQuestion(@RequestParam(name = "id") Integer id){
      return questionService.deleteOneQuestion(id);
    }
}
