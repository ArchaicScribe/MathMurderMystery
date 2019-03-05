package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class MathProblem {

  @PrimaryKey
  @ColumnInfo
  @NonNull
  private String problemId;
  @ColumnInfo(name = "level_difficulty_of_problems")
  @NonNull
  private String problemDifficulty;
  @ColumnInfo
  @NonNull
  private long problemAnswer;
  @ColumnInfo
  private long numberOfAttemptsPermitted;
  @ColumnInfo
  private String poolOfProblems;

  public String getProblemId() {
    return problemId;
  }

  public void setProblemId(String problemId) {
    this.problemId = problemId;
  }

  public String getProblemDifficulty() {
    return problemDifficulty;
  }

  public void setProblemDifficulty(String problemDifficulty) {
    this.problemDifficulty = problemDifficulty;
  }

  public long getProblemAnswer() {
    return problemAnswer;
  }

  public void setProblemAnswer(long problemAnswer) {
    this.problemAnswer = problemAnswer;
  }

  public long getNumberOfAttemptsPermitted() {
    return numberOfAttemptsPermitted;
  }

  public void setNumberOfAttemptsPermitted(long numberOfAttemptsPermitted) {
    this.numberOfAttemptsPermitted = numberOfAttemptsPermitted;
  }

  public String getPoolOfProblems() {
    return poolOfProblems;
  }

  public void setPoolOfProblems(String poolOfProblems) {
    this.poolOfProblems = poolOfProblems;
  }
}