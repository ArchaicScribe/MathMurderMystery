package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


@Entity
/**
 *  This entity will interact with the {@link MathProblem} class. The columns for this entity are
 *  designed to keep track of the math problems that are given to the user. It will track the
 *  mathProblem entirely.
 */
public class MathProblem {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "problem_id", index = true)
  @Expose
  private long problemId;
  @ColumnInfo(name = "difficulty", index = true)
  @Expose
  private Difficulty difficulty;
  @ColumnInfo(name = "type", index = true)
  @Expose
  private Type type;
  @ColumnInfo(name = "correct_answer", index = true)
  @Expose
  @SerializedName("correct_answer")
  private String correctAnswer;
  @ColumnInfo(name = "incorrect_answer", index = true)
  @Expose
  @SerializedName("incorrect_answers")
  private List<String> incorrectAnswers;
  @ColumnInfo(name = "attempts", index = true)
  private long attempts;
  @ColumnInfo(name = "pool_of_problems")
  @Expose
  private String poolProblems;
  @ColumnInfo(name = "outcome", index = true)
  @Expose
  private boolean outcome;
  @ColumnInfo(name = "question", index = true)
  @Expose
  @SerializedName("question")
  private String question;

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

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public List<String> getIncorrectAnswers() {
    return incorrectAnswers;
  }

  public void setIncorrectAnswers(List<String> incorrectAnswers) {
    this.incorrectAnswers = incorrectAnswers;
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

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
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

