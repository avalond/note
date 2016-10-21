package avalond.note;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * @author kevin.
 */

public class NoteApplication extends Application {


  @Override
  public void onCreate() {

    super.onCreate();

  }

  @Override
  public void onLowMemory() {

    super.onLowMemory();
  }

  @Override
  protected void attachBaseContext(Context base) {

    super.attachBaseContext(base);
    MultiDex.install(this);
  }
}
