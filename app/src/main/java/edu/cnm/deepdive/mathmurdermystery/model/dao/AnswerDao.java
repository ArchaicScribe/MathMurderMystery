package edu.cnm.deepdive.mathmurdermystery.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Answer;
import edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem;
import java.util.List;

@Dao
public interface AnswerDao {

  @Insert
  List<Long> insert(Answer...answers);

  @Update
  void update(Answer answers);

  @Query("SELECT * FROM Answer ORDER BY pool_of_problems DESC")
  List<MathProblem>getAll();

  @Query("SELECT * FROM MathProblem WHERE difficulty = :difficulty ORDER BY RANDOM() LIMIT 1")
  MathProblem getRandom(String difficutly);
}
