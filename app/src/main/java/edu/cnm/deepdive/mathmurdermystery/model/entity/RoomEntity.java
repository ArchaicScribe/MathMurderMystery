package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Level;

@Entity (foreignKeys = @ForeignKey(entity = Level.class,
    parentColumns = "level_id", childColumns = "level_id"))
public class RoomEntity {

  @PrimaryKey
  private long roomId;
  @ColumnInfo(name = "level_id", index = true)
  private long levelId;

  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }

  public long getLevelId() {
    return levelId;
  }

  public void setLevelId(long levelId) {
    this.levelId = levelId;
  }
}
