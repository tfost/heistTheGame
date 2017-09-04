package brassgames.heist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import brassgames.heist.R;
import brassgames.heist.util.User;

import static brassgames.heist.activities.MainActivity.HOST;
import static brassgames.heist.activities.MainActivity.NAME;
import static brassgames.heist.activities.MainActivity.ROOM;

public class LobbyActivity extends AppCompatActivity {
    ArrayList<User> userList;
    ArrayAdapter<User> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        Intent data = getIntent();
        String name = (String) data.getExtras().get(NAME);
        String room = (String) data.getExtras().get(ROOM);
        boolean host = (boolean) data.getExtras().get(HOST);

        ((TextView) findViewById(R.id.user_info)).setText(name + "\n" + room);

        ListView userListView = (ListView) findViewById(R.id.user_list);
        userList = dummyList();
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList);
        userListView.setAdapter(listAdapter);

        if(host) {
            findViewById(R.id.button_start).setVisibility(View.VISIBLE);
        }

        //  setup socket listener, call listAdapter.notifyDataSetChanged() after modifying userList if needed
    }

    private ArrayList<User> dummyList() {
        ArrayList<User> result = new ArrayList<>();
        result.add(new User("Anthony",true));
        result.add(new User("Tyler", false));
        result.add(new User("Sean", true, true));
        result.add(new User("Doug", false));
        result.add(new User("Jenni", true));
        result.add(new User("Pat", false));
        result.add(new User("Joe", true));
        return result;
    }

}
