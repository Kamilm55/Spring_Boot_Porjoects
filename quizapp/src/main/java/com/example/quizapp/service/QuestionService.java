package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.quizapp.model.Question;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public void addQuestionsList(List<Question> questionList) {
        questionRepository.saveAll(questionList);
    }

    public ResponseEntity<String> deleteOneQuestion(Integer id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isEmpty()){
            return new ResponseEntity<>("There is no question with this id", HttpStatus.NOT_FOUND);
        }

        try{
            questionRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Question which is id: " + id + " deleted", HttpStatus.OK);
    }

    public List<Question> getAllQuestionsByDifficulty(String difficulty) {
        return questionRepository.findAllByDifficulty(difficulty);
    }
}
