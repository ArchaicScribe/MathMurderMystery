package edu.cnm.deepdive.mathmurdermystery.model.entity;
/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * This class is used to store the user's information, progress, and score. The purpose of this
 * is to keep all details on the scoreboard for the user to see.
 */
@Entity
public class UserInformation {

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "user_id", index = true)
  private String userId;
  @ColumnInfo(name = "username", index = true)
  @NonNull
  private String username;
  @ColumnInfo(name = "user_progress", index = true)
  @NonNull
  private String userProgress;



  private Float score;

  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }

  @NonNull
  public String getUserId() {
    return userId;
  }

  public void setUserId(@NonNull String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserProgress() {
    return userProgress;
  }

  public void setUserProgress(String userProgress) {
    this.userProgress = userProgress;
  }
}

