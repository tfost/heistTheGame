package brassgames.heist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import brassgames.heist.R;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "name";
    public static final String ROOM  = "room";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_name);
    }

    public void join(View view) {
        ((EditText) findViewById(R.id.room)).setVisibility(View.VISIBLE);
        ((Button) findViewById(R.id.join)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.host)).setText(R.string.action_join_room);
    }

    public void launchLobby(View view) {
        try {
            String name = ((EditText) findViewById(R.id.name)).getText().toString();
            String room = ((EditText) findViewById(R.id.room)).getText().toString();
            Intent intent = new Intent(this, LobbyActivity.class);
            intent.putExtra(NAME, name);
            intent.putExtra(ROOM, room);
            startActivity(intent);
        } catch (Exception ignored){ /*maybe show "you're an idiot" message prompting username validation correction*/}
    }
}
