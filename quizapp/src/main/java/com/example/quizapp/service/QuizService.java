package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionRepository;
import com.example.quizapp.dao.QuizDao;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuestionDto;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.util.QuizUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public ResponseEntity<List<QuestionDto>> getQuizById(Integer quizId) {
       Optional<Quiz> quiz = quizDao.findById(quizId);

       if(quiz.isEmpty()){
           throw new IllegalStateException("There is no quiz with this id:" +quizId );
       }

        List<QuestionDto> formattedQuestions = QuizUtils.addQuestionsToList(quiz);

       return new ResponseEntity<>(formattedQuestions,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionDto>> getQuizByTitle(String quizTitle) {
        Optional<Quiz> quiz = quizDao.findQuizByTitle(quizTitle);

        if(quiz.isEmpty()){
            throw new IllegalStateException("There is no quiz with this title:" + quizTitle);
        }

        List<QuestionDto> formattedQuestions = QuizUtils.addQuestionsToList(quiz);

        return new ResponseEntity<>(formattedQuestions , HttpStatus.OK);

    }

    public ResponseEntity<Boolean> checkAnswer(Integer quizId, Integer questionId, String userAnswer) {
        Optional<Quiz> quiz = quizDao.findById(quizId);

        if(quiz.isEmpty()){
            throw new IllegalStateException("There is no quiz with this id:" +quizId );
        }

        List<Question> questionsFromDB = quiz.get().getQuestionList();
        Question selectedQuestion = null;
        for (Question q : questionsFromDB){
            if(Objects.equals(questionId, q.getId())){
                selectedQuestion = q;
                break; // No need to continue searching once we find the question
            }
        }

        if(selectedQuestion == null){
            throw new IllegalStateException("There is no question with this id:" + questionId + " in this quiz" );
        }

        if(selectedQuestion.getRightAnswer().equals(userAnswer)){
            return new ResponseEntity<Boolean>(true , HttpStatus.OK);
        }else {
            return new ResponseEntity<Boolean>(false , HttpStatus.BAD_REQUEST);
        }
    }
}
