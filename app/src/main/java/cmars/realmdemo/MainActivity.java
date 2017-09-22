package cmars.realmdemo;

import android.database.Observable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import cmars.realmdemo.data.Dog;
import io.realm.Realm;
import io.realm.RealmResults;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try(Realm realm = Realm.getDefaultInstance()) {

            realm.executeTransaction(realm1 -> realm1.delete(Dog.class));

            List<Dog> dogs = Arrays.asList(new Dog("Bob", 10),
                    new Dog("Mike", 15),
                    new Dog("Rachel", 5));

            RealmResults<Dog> dogsFromRealm = realm.where(Dog.class)
                    .greaterThan("age", 5)
                    .findAll();

            realm.executeTransaction(asyncRealm -> asyncRealm.copyToRealm(dogs));
                        Timber.d("Dogs found: %d", dogsFromRealm.size());
                        for(Dog dog:dogsFromRealm) {
                            Timber.d(dog.toString());
                        }
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
