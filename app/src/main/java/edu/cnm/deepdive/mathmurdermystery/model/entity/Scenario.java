package edu.cnm.deepdive.mathmurdermystery.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity

public class Scenario {

  @PrimaryKey
  private long scenarioId;
  @ColumnInfo(name = "scenario_title", index = true)
  private String scenarioTitle;

  public long getScenarioId() {
    return scenarioId;
  }

  public void setScenarioId(long scenarioId) {
    this.scenarioId = scenarioId;
  }

  public String getScenarioTitle() {
    return scenarioTitle;
  }

  public void setScenarioTitle(String scenarioTitle) {
    this.scenarioTitle = scenarioTitle;
  }
}
