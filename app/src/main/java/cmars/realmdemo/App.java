package cmars.realmdemo;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by cmars on 9/22/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
