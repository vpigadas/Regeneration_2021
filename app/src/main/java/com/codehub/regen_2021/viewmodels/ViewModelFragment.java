package com.codehub.regen_2021.viewmodels;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.codehub.regen_2021.R;

public class ViewModelFragment extends Fragment {

    public ViewModelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_model, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.printResult();

        if (getActivity() != null) {
            MyViewModel parentViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
            parentViewModel.printResult();

            parentViewModel.liveData.observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    TextView textView = view.findViewById(R.id.viewmodel_txt);
                    textView.setText(s);
                }
            });

            parentViewModel.liveData.removeObservers(getViewLifecycleOwner());
        }
    }
}