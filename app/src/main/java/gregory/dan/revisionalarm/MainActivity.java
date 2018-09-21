package gregory.dan.revisionalarm;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import gregory.dan.revisionalarm.Room.Answer;
import gregory.dan.revisionalarm.Room.Question;
import gregory.dan.revisionalarm.Room.Subject;
import gregory.dan.revisionalarm.view_model.AppViewModel;

public class MainActivity extends AppCompatActivity {

    AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        for(int i = 0; i < 5; i++){
            createSubject("test");
            SystemClock.sleep(5);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    private void createSubject(String title){
        long dtg = System.currentTimeMillis();
        SystemClock.sleep(100);
        appViewModel.insertToDatabase(new Subject(dtg, title));
    }

    private void createQuestion(long subjectId, String title){
        long dtg = System.currentTimeMillis();
        appViewModel.insertToDatabase(new Question(dtg, subjectId, title));
        SystemClock.sleep(100);
        appViewModel.insertToDatabase(new Answer(dtg, subjectId, title + ": answer"));


    }
}
