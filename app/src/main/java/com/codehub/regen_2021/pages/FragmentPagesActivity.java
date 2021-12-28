package com.codehub.regen_2021.pages;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.codehub.regen_2021.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragemt_pages);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(Page1Fragment.newInstance("Vassilis"));
        fragmentList.add(Page2Fragment.newInstance("Markos"));
        fragmentList.add(Page1Fragment.newInstance("Eleftheria"));
        fragmentList.add(Page2Fragment.newInstance("Mariam"));
        fragmentList.add(Page1Fragment.newInstance("Giannis"));
        fragmentList.add(Page2Fragment.newInstance("Alexandros"));

        ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(new CustomPageAdapter(getSupportFragmentManager(), fragmentList));
    }
}