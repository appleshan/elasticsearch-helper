package com.example.elasticsearchhepler.entity;

import com.example.elasticsearchhepler.annotations.ESDocument;
import com.example.elasticsearchhepler.annotations.ESField;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

@ESDocument(indexName = "test_index_auto")
@Component
public class TestIndexAutoEntity extends BaseEsEntity implements Serializable {
    private static final long serialVersionUID = -7298596379026894107L;

    public TestIndexAutoEntity() {
    }

    public TestIndexAutoEntity(String userName, String userTitle, double userScore, float weight, Boolean studyFlag,
                               Integer userAge, Long runDistance, LocalDateTime birthDate) {
        this.userName = userName;
        this.userTitle = userTitle;
        this.userScore = userScore;
        this.weight = weight;
        this.studyFlag = studyFlag;
        this.userAge = userAge;
        this.runDistance = runDistance;
        this.birthDate = birthDate;
    }

    @ESField(name = "user_name")
    private String userName;

    @ESField(name = "user_title")
    private String userTitle;

    @ESField(name = "user_score")
    private double userScore;

    @ESField(name = "weight")
    private float weight;

    @ESField(name = "study_flag")
    private Boolean studyFlag;

    @ESField(name = "user_age")
    private Integer userAge;

    @ESField(name = "run_distance")
    private Long runDistance;

    @ESField(name = "birth_date")
    private LocalDateTime birthDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public double getUserScore() {
        return userScore;
    }

    public void setUserScore(double userScore) {
        this.userScore = userScore;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Boolean getStudyFlag() {
        return studyFlag;
    }

    public void setStudyFlag(Boolean studyFlag) {
        this.studyFlag = studyFlag;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Long getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(Long runDistance) {
        this.runDistance = runDistance;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
