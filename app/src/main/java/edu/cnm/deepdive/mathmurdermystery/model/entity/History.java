package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * The relation between {@link History} and {@link UserInformation} will be through the user_id
 * parents and children columns.
 */
@Entity(foreignKeys = @ForeignKey(entity = UserInformation.class,
    parentColumns = "user_id", childColumns = "user_id"))
/**
 * This {@link History} class will create two different columns; problem_id and user_id.
 * This will keep track of the user and problem ids.
 */
public class History {

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "problem_id", index = true)
  private String problemId;
  @ColumnInfo(name = "user_id", index = true)
  @NonNull
  private String userId;

  public String getProblemId() {
    return problemId;
  }

  public void setProblemId(@NonNull String problemId) {
    this.problemId = problemId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
