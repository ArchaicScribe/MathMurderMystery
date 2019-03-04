package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity

public class Scenarios {

  @PrimaryKey
  private int scenarioId;
  @ColumnInfo
  private String scenarioTitle;
}
