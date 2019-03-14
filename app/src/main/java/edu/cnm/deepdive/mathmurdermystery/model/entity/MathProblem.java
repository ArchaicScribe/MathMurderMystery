package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;


@Entity

public class MathProblem {

  @PrimaryKey
  @ColumnInfo(name = "problem_id", index = true)
  @NonNull
  @Expose
  private String problemId;
  @ColumnInfo(name = "difficulty", index = true)
  @NonNull
  @Expose
  private String difficulty;
  @ColumnInfo(name = "answer", index = true)
  @Expose
  private long answer;
  @ColumnInfo(name = "attempts", index = true)
  private long attempts;
  @ColumnInfo(name = "pool_of_problems")
  @NonNull
  @Expose
  private String poolProblems;
  @ColumnInfo(name = "outcome", index = true)
  @Expose
  private boolean outcome;

  public String getProblemId() {
    return problemId;
  }

  public void setProblemId(String problemId) {
    this.problemId = problemId;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public long getAnswer() {
    return answer;
  }

  public void setAnswer(long answer) {
    this.answer = answer;
  }

  public long getAttempts() {
    return attempts;
  }

  public void setAttempts(long attempts) {
    this.attempts = attempts;
  }

  public String getPoolProblems() {
    return poolProblems;
  }

  public void setPoolProblems(String poolProblems) {
    this.poolProblems = poolProblems;
  }

  public boolean isOutcome() {
    return outcome;
  }

  public void setOutcome(boolean outcome) {
    this.outcome = outcome;
  }
}
