package edu.cnm.deepdive.mathmurdermystery.model.entity;
/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;

/**
 * The purpose of this entity class, Answer, is to differentiate between the answers and questions.
 * This is for the {@link edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB} and help
 * clarify to the system what is needed
 */
@Entity
public class Answer {

  @PrimaryKey
  @ColumnInfo(name = "answer", index = true)
  @Expose
  private long answerId;
  @ColumnInfo(name = "problem_id", index = true)
  @NonNull
  @Expose
  private long problemId;

  @ColumnInfo
  private String text;


  private boolean correct;

  public long getAnswerId() {
    return answerId;
  }

  public void setAnswerId(long answerId) {
    this.answerId = answerId;
  }

  public long getProblemId() {
    return problemId;
  }

  public void setProblemId(long problemId) {
    this.problemId = problemId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isCorrect() {
    return correct;
  }

  public void setCorrect(boolean correct) {
    this.correct = correct;
  }
}
