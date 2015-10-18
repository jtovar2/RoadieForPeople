package hackatl.com.roadieforpeople;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackatl.com.roadieforpeople.model.RoadieUser;


/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link PlaceRouteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlaceRouteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String LOCALITY = "param1";

    // TODO: Rename and change types of parameters
    private String mStartingLocation;
    Context mContext;
    RoutesApi mApi;
    RoadieUser mUser;
    View mView;
    PlaceRouteLayoutv2 mPlaceRouteLayout;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PlaceRouteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlaceRouteFragment newInstance(String locality) {
        PlaceRouteFragment fragment = new PlaceRouteFragment();
        Bundle args = new Bundle();
        args.putString(LOCALITY, locality);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceRouteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStartingLocation = getArguments().getString(LOCALITY);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_place_route, container, false);

        mPlaceRouteLayout = (PlaceRouteLayoutv2) mView.findViewById(R.id.placeRouteLayout);

        return mView;
    }

    @Override
    public void onAttach(Context newContext)
    {
        super.onAttach(newContext);

        mContext = newContext;
        mApi = ((RoadieForPeople) getActivity().getApplication()).getApi();
        mUser = ((RoadieForPeople) getActivity().getApplication()).getUser();




    }
    @Override
    public void onStart()
    {
        super.onStart();

        mPlaceRouteLayout.setApi(mApi);
        mPlaceRouteLayout.setStartLocation(mStartingLocation);
        mPlaceRouteLayout.setUser(mUser);

    }



}
