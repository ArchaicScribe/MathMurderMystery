package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Scenario;
import java.util.List;

/**
 * The scenario DAO will be populated from the
 * {@link edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB}
 * and then it will gather all of the
 */
@Dao
public interface ScenarioDao {

  @Insert
  List<Long> insert(Scenario... scenarios);

  @Insert
  List<Long> insert(List<Scenario> scenarios);


  @Insert
  Long insert(Scenario scenario);

  @Query("SELECT * FROM Scenario")
  List<Scenario> getAllScenarios();

  @Query("SELECT * FROM Scenario WHERE scenario_title = :scenarioTitle")
  Scenario findFirstByScenarioTitle(String scenarioTitle);

}
