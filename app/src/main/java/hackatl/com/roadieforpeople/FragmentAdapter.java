package hackatl.com.roadieforpeople;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by javier on 10/17/15.
 */
public class FragmentAdapter extends FragmentPagerAdapter {


    FragmentManager mFragmentManager;

    SparseArray<Fragment> mAvailableFragments;

    public FragmentAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
        mFragmentManager = fragmentManager;
        mAvailableFragments = new SparseArray<Fragment>();
    }




    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SupportMapFragment mapFragment = SupportMapFragment.newInstance();
                return mapFragment;
            default:
                //TODO create Fragment to create route
                SupportMapFragment mapViewFragment = SupportMapFragment.newInstance();
                return mapViewFragment;
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return MainActivity.NUM_FRAGMENTS;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mAvailableFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        mAvailableFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return mAvailableFragments.get(position);
    }
}
