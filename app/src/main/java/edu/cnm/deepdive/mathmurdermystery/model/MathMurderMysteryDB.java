package edu.cnm.deepdive.mathmurdermystery.model;

import static edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem.Difficulty.EASY;
import static edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem.Difficulty.HARD;
import static edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem.Difficulty.MEDIUM;
import static edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem.Type.BOOLEAN;
import static edu.cnm.deepdive.mathmurdermystery.model.entity.MathProblem.Type.MULTIPLE;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.Gson;
import edu.cnm.deepdive.android.BaseFluentAsyncTask;
import edu.cnm.deepdive.mathmurdermystery.MathMurderMysteryApplication;
import edu.cnm.deepdive.mathmurdermystery.R;
import edu.cnm.deepdive.mathmurdermystery.model.MathMurderMysteryDB.Converters;
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
import java.sql.Wrapper;
import java.util.Arrays;
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
@TypeConverters(Converters.class)
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
      getAScenario(context, db);
      getLevels(context, db);
      getRoomEntities(context, db);
      Gson gson = new Gson();
      MathProblem[] arr = gson.fromJson(new InputStreamReader(context.getResources().
          openRawResource(R.raw.questions)), MathProblem[].class);
      db.getMathProblem().insert(Arrays.asList(arr));
      return null;
    }

    private void getAScenario(Context context, MathMurderMysteryDB db) {
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
      } catch (IOException e) {
        throw new TaskException(e);
      }
    }


    private List<Level> getLevels(Context context,
        MathMurderMysteryDB db) {
      try (
          InputStream inputStream = context.getResources().openRawResource(R.raw.levels);
          Reader reader = new InputStreamReader(inputStream);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
      ) {
        List<Level> levels = new LinkedList<>();
        for (CSVRecord record : parser) {
          Level level = new Level();
          level.setLevelId(Long.parseLong(record.get(0)));
          level.setScenrioId(Long.parseLong(record.get(2)));
          level.setLevelTitle(record.get(1));
          levels.add(level);
        }
        db.getLevelDao().insert(levels);
        return null;
      } catch (IOException e) {
        throw new TaskException(e);
      }
    }


    private List<RoomEntity> getRoomEntities(Context context,
        MathMurderMysteryDB db) {
      try (
          InputStream inputStream = context.getResources().openRawResource(R.raw.rooms);
          Reader reader = new InputStreamReader(inputStream);
          CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
      ) {
        List<RoomEntity> entities = new LinkedList<>();
        for (CSVRecord record : parser) {
          RoomEntity entity = new RoomEntity();
          entity.setRoomId(Long.parseLong(record.get(0)));
          entity.setLevelId(Long.parseLong(record.get(2)));
          entities.add(entity);
        }
        db.getRoomEntity().insert(entities);
        return null;
      } catch (IOException e) {
        throw new TaskException(e);
      }
    }
  }


  public static class Converters {

    @TypeConverter
    public static MathProblem.Difficulty difficulty(int difficulty) {
      if (difficulty == EASY.ordinal()) {
        return EASY;
      } else if (difficulty == MEDIUM.ordinal()) {
        return MEDIUM;
      } else if (difficulty == HARD.ordinal()) {
        return HARD;
      } else {
        throw new IllegalArgumentException("Could not assign difficulty");
      }
    }

    @TypeConverter
    public static int difficultyToInt(MathProblem.Difficulty difficulty) {
      return difficulty.ordinal();
    }


    @TypeConverter
    public static MathProblem.Type type(int type) {
      if (type == MULTIPLE.ordinal()) {
        return MULTIPLE;
      } else if (type == BOOLEAN.ordinal()) {
        return BOOLEAN;
      } else {
        throw new IllegalArgumentException("Could not assign type");
      }
    }

    @TypeConverter
    public static int typeToInt(MathProblem.Type type) {
      return type.ordinal();

    }
  }
}