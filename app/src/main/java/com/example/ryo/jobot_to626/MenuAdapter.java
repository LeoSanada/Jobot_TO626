package com.example.ryo.jobot_to626;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Alexander on 12/17/2016.
 */

public class MenuAdapter extends FragmentPagerAdapter {
    public MenuAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(final int i) {

        Fragment topmenu = new TopMenuFragment();
        final Bundle bundle = new Bundle();
        bundle.putInt("count",i+1);
        topmenu.setArguments(bundle);

        return topmenu;

    }

    @Override
    public int getCount() {
        return 1;
    }
}
