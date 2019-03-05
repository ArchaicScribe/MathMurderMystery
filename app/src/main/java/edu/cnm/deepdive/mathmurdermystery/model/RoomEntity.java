package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity (foreignKeys = @ForeignKey(entity = Level.class,
    parentColumns = "level_id", childColumns = "level_id"))
public class RoomEntity {

  @PrimaryKey
  private int roomId;
  @ColumnInfo
  private int levelId;

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public int getLevelId() {
    return levelId;
  }

  public void setLevelId(int levelId) {
    this.levelId = levelId;
  }
}
