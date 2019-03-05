package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity

public class Connection {

  @PrimaryKey
  @NonNull
  private String roomId;

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }
}
