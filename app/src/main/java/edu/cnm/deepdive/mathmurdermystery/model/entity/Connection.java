package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;


@Entity(
    primaryKeys = {"room_id1", "room_id2"},
    foreignKeys = {
        @ForeignKey(entity = RoomEntity.class, parentColumns = "room_id", childColumns = "room_id1"),
        @ForeignKey(entity = RoomEntity.class, parentColumns = "room_id", childColumns = "room_id2")
    }
)
public class Connection {


  @ColumnInfo(name = "room_id1", index = true)
  private long roomId1;

  @ColumnInfo(name = "room_id2", index = true)
  private long roomId2;

  public long getRoomId1() {
    return roomId1;
  }

  public void setRoomId1(long roomId1) {
    this.roomId1 = roomId1;
  }

  public long getRoomId2() {
    return roomId2;
  }

  public void setRoomId2(long roomId2) {
    this.roomId2 = roomId2;
  }
}
