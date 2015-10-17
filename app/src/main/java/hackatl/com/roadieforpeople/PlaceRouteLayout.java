package hackatl.com.roadieforpeople;

import android.widget.EditText;
// import android.widget.DatePicker;
import android.widget.Button;
/**
 * Created by andrewli on 10/17/15.
 */
public class PlaceRouteLayout
{
    private EditText endpoint;
    private EditText leavingDate;
    private Button button;

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