package brassgames.heist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import brassgames.heist.R;

import static brassgames.heist.activities.MainActivity.NAME;
import static brassgames.heist.activities.MainActivity.ROOM;

public class LobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String name = (String) intent.getExtras().get(NAME);
        String room = (String) intent.getExtras().get(ROOM);
        ((TextView) findViewById(R.id.info)).setText(name + "\n" + room);
    }

}
