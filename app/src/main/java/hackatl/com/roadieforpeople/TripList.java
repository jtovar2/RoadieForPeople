package hackatl.com.roadieforpeople;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;
import java.util.Locale;

import hackatl.com.roadieforpeople.model.RoadieGeoPoint;

public class TripList extends AppCompatActivity {

    public static final String DATE = "date";
    ListView mListView;
    ArrayAdapter<String> mAdapter;

    String endLocation;
    String startLocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);


        endLocation = null;
        Intent intent = getIntent();
        startLocation = (String) intent.getSerializableExtra(MainActivity.STARTLOCATION);
        RoadieGeoPoint position = (RoadieGeoPoint) intent.getSerializableExtra(MainActivity.LATLNG);
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try
        {
            List<Address> adresses = geocoder.getFromLocation(position.latitude, position.longitude, 2);
            endLocation = adresses.get(0).getLocality();
        }
        catch (Exception e)
        {

        }

        mListView = (ListView) findViewById(R.id.listViewTrip);
        String[] routes = new String[4];
        routes[3] = "10/19/2015 - Price $40.00";
        routes[2] = "10/23/2015 - Price $30.00";
        routes[1] = "10/22/2015 - Price $20.00";
        routes[0] = "10/28/2015 - Price $15.00";

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, routes);
        mListView.setAdapter(mAdapter);





        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent2 = new Intent(TripList.this, TripInfo.class);
                intent2.putExtra(MainActivity.STARTLOCATION, startLocation);
                intent2.putExtra(MainActivity.ENDLOCATION, endLocation);
                switch(position)
                {
                    case 0:
                        intent2.putExtra(DATE, "10/19/2015");
                        break;
                    case 1:
                        intent2.putExtra(DATE, "10/23/2015");
                        break;
                    case 2:
                        intent2.putExtra(DATE, "10/22/2015");
                        break;
                    default:
                        intent2.putExtra(DATE, "10/28/2015");
                }
                startActivity(intent2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trip_list, menu);
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
