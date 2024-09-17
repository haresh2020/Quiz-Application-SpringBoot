package com.example.store.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.swing.text.html.Option;

@Entity
@Table(name="question")
public class Quest{
    @Id
    private int Questionno;
    private String Question;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String Answer;
    private String stream;

    public int getQuestionno() {
        return Questionno;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }
//    public int getQuestionno(){
//        return Questionno;
//    }
    public void setQuestionno(int Questionno){
        this.Questionno=Questionno;
    }
    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        this.Question = question;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        this.Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        this.Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {

        this.Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {

        this.Option4 = option4;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {

        this.Answer = Answer;
    }


}
