package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity

public class Connection {

  @PrimaryKey
  private String roomId;
}
