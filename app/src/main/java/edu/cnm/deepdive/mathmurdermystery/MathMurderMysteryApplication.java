package edu.cnm.deepdive.mathmurdermystery;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class MathMurderMysteryApplication extends Application {

  private static MathMurderMysteryApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this);
  }

  public static MathMurderMysteryApplication getInstance() {
    return instance;
  }
}
