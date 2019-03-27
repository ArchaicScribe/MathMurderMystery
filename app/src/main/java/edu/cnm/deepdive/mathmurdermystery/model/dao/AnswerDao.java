package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Answer;
import edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem;
import java.util.List;

/**
 * This will access all of the answers from the {@link edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB}.
 */
@Dao
public interface AnswerDao {

  @Insert
  List<Long> insert(Answer... answers);

  @Update
  void update(Answer answers);

  /**
   * Requests all of the {@link MathProblem} and lists them in descending order.
   */
  @Query("SELECT * FROM Answer ORDER BY pool_of_problems DESC")
  List<MathProblem> getAll();

  /**
   * This will randomize the difficulty of the problems that are gathered from the {@link
   * edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB}.
   */
  @Query("SELECT * FROM MathProblem WHERE difficulty = :difficulty ORDER BY RANDOM() LIMIT 1")
  MathProblem getRandom(String difficulty);
}
