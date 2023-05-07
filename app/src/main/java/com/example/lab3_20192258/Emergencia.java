package com.example.lab3_20192258;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab3_20192258.databinding.FragmentEmergenciaBinding;


public class Emergencia extends Fragment {

    FragmentEmergenciaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEmergenciaBinding.inflate(inflater,container,false);

        // Get the FragmentManager for the child fragments
        FragmentManager childFragmentManager = getChildFragmentManager();

        // Begin a FragmentTransaction
        FragmentTransaction transaction = childFragmentManager.beginTransaction();

        // Create the nested fragment and add it to the container fragment
        MapFragment nestedFragment = new MapFragment();
        transaction.add(R.id.frame_layout, nestedFragment);

        // Commit the FragmentTransaction
        transaction.commit();

        return binding.getRoot();
    }
}