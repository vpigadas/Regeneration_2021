package com.codehub.regen_2021.pages;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class CustomPageAdapter extends FragmentPagerAdapter {

    List<Fragment> arrayData;

    public CustomPageAdapter(@NonNull FragmentManager fm, List<Fragment> arrayData) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayData.get(position);
    }

    @Override
    public int getCount() {
        return arrayData.size();
    }
}
