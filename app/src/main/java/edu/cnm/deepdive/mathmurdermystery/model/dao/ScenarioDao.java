package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.Scenario;
import java.util.List;

@Dao
public interface ScenarioDao {

  @Insert
  public long insertScenario(Scenario scenario);

  @Query("SELECT * FROM Scenario")
  public List<Scenario> getAllScenarios();
}
