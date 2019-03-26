package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;
import java.util.Calendar;

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
  @NonNull
  @TypeConverter
  private Calendar time = Calendar.getInstance();

  private Float score;

  @NonNull
  public Calendar getTime() {
    return time;
  }

  public void setTime(@NonNull Calendar time) {
    this.time = time;
  }

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

