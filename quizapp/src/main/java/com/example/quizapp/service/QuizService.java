package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionRepository;
import com.example.quizapp.dao.QuizDao;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizDao quizDao;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuizService(QuizDao quizDao, QuestionRepository questionRepository) {
        this.quizDao = quizDao;
        this.questionRepository = questionRepository;
    }

    public ResponseEntity<Quiz> addQuiz(int num, String title, String category) {
        List<Question> randomQuestions = questionRepository.findRandomQuestions(num,category);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(randomQuestions);

        boolean isExistQuizWithThisTitle = quizDao.existsQuizByTitle(title);
        if(isExistQuizWithThisTitle){
            throw new IllegalStateException("There is already a quiz with " + title + " title");
        }

        quizDao.save(quiz);
        return new ResponseEntity<>(quiz , HttpStatus.CREATED);
    }

    public ResponseEntity<Optional<Quiz>> getQuizById(Integer quizId) {
       Optional<Quiz> quiz = quizDao.findById(quizId);

       if(quiz.isEmpty()){
           throw new IllegalStateException("There is no quiz with this id");
       }


       return new ResponseEntity<>(quiz,HttpStatus.OK);
    }
}
