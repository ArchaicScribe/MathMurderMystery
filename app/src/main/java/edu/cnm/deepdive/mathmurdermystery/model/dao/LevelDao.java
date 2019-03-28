package edu.cnm.deepdive.mathmurdermystery.model.dao;
/**
 *  @author Alex Rauenzahn
 *  @version 1.0
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Level;
import java.util.List;

/**
 * This DAO will act as a go-between for the {@link edu.cnm.deepdive.mathmurdermystery.controller.LevelFragment},
 * {@link edu.cnm.deepdive.mathmurdermystery.model.entity.RoomEntity}, and {@link
 * edu.cnm.deepdive.mathmurdermystery.controller.ScenarioFragment}.
 */
@Dao
public interface LevelDao {

  @Insert
  List<Long> insert(Level... scenarios);

  @Insert
  List<Long> insert(List<Level> scenarios);


  @Insert
  Long insertLevel(Level level);

  @Query("SELECT * FROM Level")
  List<Level> getAllLevels();

  @Query("SELECT * FROM level WHERE scenario_id =:scenarioId")
  List<Level> findAllByScenarioId(long scenarioId);

  @Query("SELECT * FROM level WHERE scenario_id =:scenarioId AND level_title =:levelTitle")
  List<Level> findFirstByScenarioIdLevelTitle(long scenarioId, String levelTitle);

}
