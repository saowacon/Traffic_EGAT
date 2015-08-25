package egat.tick.traffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Explicit ประกาศตัวแปร ที่ใช่เฉพาะ Class นี้เท่านั้น
    private ListView trafficListView;
    private Button aboutMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Widget
        bindWidget();

        //Button Controller
        buttonController();
    } // Main Method

    private void buttonController() {
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sound Effect เมื่อคลิกที่ปุ่ม
                MediaPlayer buttonMediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.effect_btn_long);
                buttonMediaPlayer.start();

                // Intent to WebView
                Intent objIntent = new Intent(Intent.ACTION_VIEW);
                objIntent.setData(Uri.parse("http://www.egat.co.th/index.php?option=com_content&view=article&id=149&Itemid=186"));
                startActivity(objIntent);
            } // Event
        });
    } //ButtonController

    private void bindWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);
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
} // Main Class นี่คือคลาสหลัก
