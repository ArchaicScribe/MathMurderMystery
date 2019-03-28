package edu.cnm.deepdive.mathmurdermystery.model.entity;
/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * This entity is designed to keep track of the scenario titles.
 */
@Entity(indices = @Index(value = "scenario_title", unique = true))

public class Scenario {

  /**
   * This will create the scenario_id and titles for columns.
   */
  @PrimaryKey
  @ColumnInfo(name = "scenario_id", index = true)
  private long scenarioId;
  @NonNull
  @ColumnInfo(name = "scenario_title")
  private String title;


  public long getScenarioId() {
    return scenarioId;
  }

  public void setScenarioId(long scenarioId) {
    this.scenarioId = scenarioId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
