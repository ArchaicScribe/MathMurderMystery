package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity

public class MathProblem {

  @PrimaryKey
  @ColumnInfo(name = "problem_id", index = true)
  @NonNull
  @Expose
  private long problemId;
  @ColumnInfo(name = "difficulty", index = true)
  @NonNull
  @Expose
  private Difficulty difficulty;
  @ColumnInfo(name = "type", index = true)
  @NonNull
  @Expose
  private Type type;
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

  public long getProblemId() {
    return problemId;
  }

  public void setProblemId(long problemId) {
    this.problemId = problemId;
  }

  @NonNull
  public Difficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(
      @NonNull Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  @NonNull
  public Type getType() {
    return type;
  }

  public void setType(@NonNull Type type) {
    this.type = type;
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

  @NonNull
  public String getPoolProblems() {
    return poolProblems;
  }

  public void setPoolProblems(@NonNull String poolProblems) {
    this.poolProblems = poolProblems;
  }

  public boolean isOutcome() {
    return outcome;
  }

  public void setOutcome(boolean outcome) {
    this.outcome = outcome;
  }

  public enum Difficulty {
    @SerializedName("easy")
    EASY,
    @SerializedName("medium")
    MEDIUM,
    @SerializedName("hard")
    HARD
  }

  public enum Type {
    @SerializedName("multiple")
    MULTIPLE,
    @SerializedName("boolean")
    BOOLEAN
  }
}

