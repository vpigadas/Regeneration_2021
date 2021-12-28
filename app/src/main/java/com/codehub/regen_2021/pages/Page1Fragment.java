package com.codehub.regen_2021.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codehub.regen_2021.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Page1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Page1Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public Page1Fragment() {
        // Required empty public constructor
    }

    public static Page1Fragment newInstance(String param1) {
        Page1Fragment fragment = new Page1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.page_one_txt);
        textView.setText(mParam1);
    }
}