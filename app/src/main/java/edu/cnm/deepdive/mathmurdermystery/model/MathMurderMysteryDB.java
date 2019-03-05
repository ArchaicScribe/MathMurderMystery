package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(
    entities = {Connection.class, History.class, Level.class, MathProblem.class, RoomEntity.class,
    Scenario.class, UserInformation.class},
    version = 1,
    exportSchema = true
)


public abstract class MathMurderMysteryDB extends RoomDatabase {

  private static final String DB_NAME = "math_murder_mystery_DB";

  public abstract Connection getConnection();

  public abstract History getHistory();

  public abstract Level getLevel();

  public abstract MathProblem getMathProblem();

  public abstract RoomEntity getRoomEntity();

  public abstract Scenario getScenario();

  public abstract UserInformation getUserInformation();

  private static MathMurderMysteryDB instance = null;

  public synchronized static MathMurderMysteryDB getInstance(Context context) {
    if (instance == null) {
      instance = Room.databaseBuilder(context.getApplicationContext(), MathMurderMysteryDB.class,
          DB_NAME).build();
    }
  return instance;
  }
}
