package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class MathProblems {

  @PrimaryKey
  @ColumnInfo
  private String problemId;
  @ColumnInfo(name = "level_difficulty_of_problems")
  private String problemDifficulty;
  @ColumnInfo
  private int problemAnswer;
  @ColumnInfo
  private int numberOfAttemptsPermitted;
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

  public int getProblemAnswer() {
    return problemAnswer;
  }

  public void setProblemAnswer(int problemAnswer) {
    this.problemAnswer = problemAnswer;
  }

  public int getNumberOfAttemptsPermitted() {
    return numberOfAttemptsPermitted;
  }

  public void setNumberOfAttemptsPermitted(int numberOfAttemptsPermitted) {
    this.numberOfAttemptsPermitted = numberOfAttemptsPermitted;
  }

  public String getPoolOfProblems() {
    return poolOfProblems;
  }

  public void setPoolOfProblems(String poolOfProblems) {
    this.poolOfProblems = poolOfProblems;
  }
}
