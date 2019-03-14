package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Scenario;
import java.util.List;

@Dao
public interface ScenarioDao {

  @Insert
  Long insertScenario(Scenario scenario);

  @Query("SELECT * FROM Scenario")
  List<Scenario> getAllScenarios();

  @Query("SELECT * FROM Scenario WHERE scenario_title = :scenarioTitle")
  Scenario findFirstByScenarioTitle(String scenarioTitle);

}
