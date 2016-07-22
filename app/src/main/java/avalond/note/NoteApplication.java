package avalond.note;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author kevin.
 */

public class NoteApplication extends Application {
  private RefWatcher mRefWatcher;

  @Override public void onCreate() {
    super.onCreate();
    mRefWatcher = LeakCanary.install(this);
  }

  @Override public void onLowMemory() {
    super.onLowMemory();
  }

  @Override protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }
}
