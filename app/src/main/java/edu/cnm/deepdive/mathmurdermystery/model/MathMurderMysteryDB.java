package edu.cnm.deepdive.mathmurdermystery.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.android.BaseFluentAsyncTask;
import edu.cnm.deepdive.mathmurdermystery.MathMurderMysteryApplication;
import edu.cnm.deepdive.mathmurdermystery.R;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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

  public abstract LevelDao getLevelDao();

  public abstract MathProblemDao getMathProblem();

  public abstract RoomEntityDao getRoomEntity();

  public abstract ScenarioDao getScenarioDao();

  public abstract UserInformationDao getUserInformation();

  private static MathMurderMysteryDB instance = null;

  private static class InstanceHolder {

    private static final MathMurderMysteryDB INSTANCE =
        Room.databaseBuilder(MathMurderMysteryApplication.getInstance().getApplicationContext(),
            MathMurderMysteryDB.class, DB_NAME)
            .addCallback(new Callback())
            .build();
  }

  private static class Callback extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      new PreloadTask().execute();
    }
  }


  private static class PreloadTask extends BaseFluentAsyncTask<Void, Void, Void, Void> {

    @Nullable
    @Override
    protected Void perform(Void... voids) throws TaskException {
      Context context = MathMurderMysteryApplication.getInstance().getApplicationContext();
      MathMurderMysteryDB db = MathMurderMysteryDB.getInstance();
      return getAScenario(context, db);
    }

    private Void getAScenario(Context context, MathMurderMysteryDB db) {
      try (
          InputStream inputStream = context.getResources().openRawResource(R.raw.scenarios);
          Reader reader = new InputStreamReader(inputStream);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
      ) {
        List<Scenario> scenarios = new LinkedList<>();
        for (CSVRecord record : parser) {
          Scenario scenario = new Scenario();
          scenario.setScenarioId(Integer.parseInt(record.get(0)));
          scenario.setTitle(record.get(1));
          scenarios.add(scenario);
        }
        db.getScenarioDao().insert(scenarios);
        return null;
      } catch (IOException e) {
        throw new TaskException(e);
      }
    }


    private List<Level> loadLevels(long levelId, String levelName) {
      Context context = MathMurderMysteryApplication.getInstance().getApplicationContext();
      int resourceId = context.getResources()
          .getIdentifier(levelName, "raw", context.getPackageName());
      return getLevels(levelId, context, resourceId);
    }

    private List<Level> getLevels(long levelId, Context context, int resourceId) {
      try (
          InputStream input = context.getResources().openRawResource(resourceId);
          Reader reader = new InputStreamReader(input);
          BufferedReader buffer = new BufferedReader(reader);
      ) {
        List<Level> levels = new LinkedList<>();
        String line;
        while ((line = buffer.readLine()) != null) {
          if (!((line = line.trim()).isEmpty())) {
            Level level = new Level();
            level.setLevelId(levelId);
            level.setLevelTitle(line);
            levels.add(level);
          }
        }
        return levels;
      } catch (IOException e) {
        throw new TaskException(e);
      }
    }


    private List<RoomEntity> loadRoomEntity(long roomEntityId, String roomEntityName) {
      Context context = MathMurderMysteryApplication.getInstance().getApplicationContext();
      int resourceId = context.getResources()
          .getIdentifier(roomEntityName, "raw", context.getPackageName());
      return getRoomEntities(roomEntityId, context, resourceId);
    }

    private List<RoomEntity> getRoomEntities(long roomEntityId, Context context, int resourceId) {
      try (
          InputStream input = context.getResources().openRawResource(resourceId);
          Reader reader = new InputStreamReader(input);
          BufferedReader buffer = new BufferedReader(reader);
      ) {
        List<RoomEntity> roomEntities = new LinkedList<>();
        String line;//Cannot be a String because it is declared as a long. Fix.
        while ((line = buffer.readLine()) != null) {
          if (!((line = line.trim()).isEmpty())) {
            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setRoomId(roomEntityId);
            roomEntity.setRoomId(line);
            roomEntities.add(roomEntity);
          }
        }
        return roomEntities;
      } catch (IOException e) {
        throw new TaskException(e);
      }
    }
  }
}