package org.codeforcoffee.listofgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<String> mVideoGameList = new ArrayList<>();
    private ArrayAdapter<String> mArrayAdapter;
    private AdapterView.OnItemClickListener mClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.games_list_view);
        mVideoGameList.add("Zelda");
        mVideoGameList.add("Mario");
        mVideoGameList.add("Starfox");
        mVideoGameList.add("Super Smash Bros");
        mVideoGameList.add("Splatoon");
        mVideoGameList.add("Pikmin");
        mVideoGameList.add("Mario Kart");

        mArrayAdapter = new ArrayAdapter<String>(this, R.layout.list_row_item, mVideoGameList);
        mListView.setAdapter(mArrayAdapter);

        mClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, Integer.toString(position) + ": " + mArrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        };

        mListView.setOnItemClickListener(mClickListener);
    }
}
