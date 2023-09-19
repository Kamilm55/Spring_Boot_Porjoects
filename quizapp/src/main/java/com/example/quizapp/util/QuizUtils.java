package com.example.quizapp.util;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuestionDto;
import com.example.quizapp.model.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuizUtils {
    private QuizUtils() {
        throw new AssertionError("This is utils class , cannot be instantiated , it contains only static methods");
    }

    public static List<QuestionDto> addQuestionsToList(Optional<Quiz> quiz){
        List<Question> questionsFromDB = quiz.get().getQuestionList();
        List<QuestionDto> formattedQuestions =  new ArrayList<>();

        for(Question q : questionsFromDB){
            QuestionDto formattedQ = new QuestionDto();
            formattedQ.setId(q.getId());
            formattedQ.setQuestionTitle(q.getQuestionTitle());
            formattedQ.setOption1(q.getOption1());
            formattedQ.setOption2(q.getOption2());
            formattedQ.setOption3(q.getOption3());
            formattedQ.setOption4(q.getOption4());

            formattedQuestions.add(formattedQ);
        }
        return formattedQuestions;
    }
}
