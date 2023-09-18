package com.example.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
//@Table
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String title;
    @ManyToMany
    @JoinTable(
            name = "quiz_question",
            joinColumns = @JoinColumn(name = "quiz_id") ,
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questionList;
//    The error message "Basic attribute type should not be a container" typically occurs when JPA is not able to map a collection type
//    (in this case, List) directly as a basic attribute in an entity. Instead, you should use a relationship mapping.
}
