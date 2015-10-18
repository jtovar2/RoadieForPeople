package hackatl.com.roadieforpeople;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TripInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_info);

        Intent i = getIntent();
        String startLocation = (String) i.getSerializableExtra(MainActivity.STARTLOCATION);
        String endLocation = (String) i.getSerializableExtra(MainActivity.ENDLOCATION);
        String date = (String) i.getSerializableExtra(TripList.DATE);

        TextView textViewEndLoc = (TextView) findViewById(R.id.textViewEndLocation);
        TextView textViewStartLoc = (TextView) findViewById(R.id.textViewStartLocation);
        TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
        TextView textViewDriver = (TextView) findViewById(R.id.textViewDriver);

        ListView listView = (ListView) findViewById(R.id.listViewRiders);
        String[] riders = new String[3];
        riders[0] = "DeRonne Floyd";
        riders[1] = "Mickey Mouse";
        riders[2] = "Lil'Wayne";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, riders);
        listView.setAdapter(adapter);

        textViewDate.setText(date);
        textViewDriver.setText("Driver - Andrew Li - (404) 332-6678");
        textViewEndLoc.setText(endLocation);
        textViewStartLoc.setText(startLocation);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trip_info, menu);
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
