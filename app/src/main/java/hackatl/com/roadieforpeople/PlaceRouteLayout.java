package hackatl.com.roadieforpeople;

import android.content.Context;
import android.widget.EditText;
// import android.widget.DatePicker;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by andrewli on 10/17/15.
 */
public class PlaceRouteLayout extends LinearLayout
{
    private EditText endpoint;
    private EditText leavingDate;
    private Button button;

    public PlaceRouteLayout(Context context) {
        super(context);
    }

    public EditText getEndpoint() {
        return endpoint;
    }
    public EditText getLeavingDate() {
        return leavingDate;
    }
    public Button getButton() {
        return button;
    }



}