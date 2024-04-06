package algonquin.cst2335.finalproject;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Dictionary;

import algonquin.cst2335.finalproject.SongMainActivity;
import algonquin.cst2335.finalproject.SRSSSunriseMainActivity;
import algonquin.cst2335.finalproject.Dist.DictionaryMainActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_more_Song) {
            Intent intent = new Intent(this,SongMainActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_more_Dict) {
            Intent intent = new Intent(this,DictionaryMainActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_more_Sun) {
            Intent intent = new Intent(this, SRSSSunriseMainActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}