package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import edu.cnm.deepdive.mathmurdermystery.model.dao.ConnectionDao;
import edu.cnm.deepdive.mathmurdermystery.model.dao.HistoryDao;
import edu.cnm.deepdive.mathmurdermystery.model.dao.LevelDao;
import edu.cnm.deepdive.mathmurdermystery.model.dao.MathProblemDao;
import edu.cnm.deepdive.mathmurdermystery.model.dao.RoomEntityDao;
import edu.cnm.deepdive.mathmurdermystery.model.dao.ScenarioDao;
import edu.cnm.deepdive.mathmurdermystery.model.dao.UserInformationDao;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Connection;
import edu.cnm.deepdive.mathmurdermystery.model.entity.History;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Level;
import edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem;
import edu.cnm.deepdive.mathmurdermystery.model.entity.RoomEntity;
import edu.cnm.deepdive.mathmurdermystery.model.entity.Scenario;
import edu.cnm.deepdive.mathmurdermystery.model.entity.UserInformation;

@Database(
    entities = {Connection.class, History.class, Level.class, MathProblem.class, RoomEntity.class,
    Scenario.class, UserInformation.class},
    version = 1,
    exportSchema = true
)


public abstract class MathMurderMysteryDB extends RoomDatabase {

  private static final String DB_NAME = "math_murder_mystery_DB";

  public static MathMurderMysteryDB getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract ConnectionDao getConnection();

  public abstract HistoryDao getHistory();

  public abstract LevelDao getLevel();

  public abstract MathProblemDao getMathProblem();

  public abstract RoomEntityDao getRoomEntity();

  public abstract ScenarioDao getScenario();

  public abstract UserInformationDao getUserInformation();

  private static MathMurderMysteryDB instance = null;

  private static class InstanceHolder {

    private static final MathMurderMysteryDB INSTANCE =
        Room.databaseBuilder(MathMurderMysteryDB.getInstance().getApplicationContext(),
            MathMurderMysteryDB.class, DB_NAME)
            .addCallback(new Callback())
            .build();

  }

  private static class Callback extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      new PreloadTask().execute;
    }


    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
      super.onOpen(db);
      MathMurderMysteryDB database = MathMurderMysteryDB.getInstance();
      new BaseFluentTask<Void, Void, >
    }

    public synchronized static MathMurderMysteryDB getInstance(Context context) {
    if (instance == null) {
      instance = Room.databaseBuilder(context.getApplicationContext(), MathMurderMysteryDB.class,
          DB_NAME).build();
    }
  return instance;
  }
}
}