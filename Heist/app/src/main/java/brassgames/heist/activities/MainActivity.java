package brassgames.heist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.net.Socket;

import brassgames.heist.R;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "name";
    public static final String ROOM  = "room";
    public static final String HOST = "host";
    public static final int PORT = 12345;

    public static Socket serverConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_name);

        try {
            serverConnection = new Socket("127.0.0.1", PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void join(View view) {
        findViewById(R.id.room).setVisibility(View.VISIBLE);
        findViewById(R.id.join).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String name = ((EditText) findViewById(R.id.name)).getText().toString();
                    String room = ((EditText) findViewById(R.id.room)).getText().toString();
                    launchLobbyActivity(name, room, false);
            }
        });
        findViewById(R.id.host).setVisibility(View.GONE);
    }

    public void launchLobbyAsHost(View view) {
        String name = ((EditText) findViewById(R.id.name)).getText().toString();
        String room = "Server Should Assign Room";
        launchLobbyActivity(name, room, true);
    }

    private void launchLobbyActivity(String name, String room, boolean host) {
        Intent intent = new Intent(this, LobbyActivity.class);
        intent.putExtra(NAME, name);
        intent.putExtra(ROOM, room);
        intent.putExtra(HOST, host);
        startActivity(intent);
    }
}
