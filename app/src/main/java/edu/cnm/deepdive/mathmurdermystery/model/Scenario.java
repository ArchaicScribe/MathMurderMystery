package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity

public class Scenario {

  @PrimaryKey
  private int scenarioId;
  @ColumnInfo
  private String scenarioTitle;

  public int getScenarioId() {
    return scenarioId;
  }

  public void setScenarioId(int scenarioId) {
    this.scenarioId = scenarioId;
  }

  public String getScenarioTitle() {
    return scenarioTitle;
  }

  public void setScenarioTitle(String scenarioTitle) {
    this.scenarioTitle = scenarioTitle;
  }
}
