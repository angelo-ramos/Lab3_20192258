package com.example.lab3_20192258;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab3_20192258.databinding.FragmentEmergenciaBinding;
import com.example.lab3_20192258.databinding.FragmentRegistroBinding;


public class Emergencia extends Fragment {

    FragmentEmergenciaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEmergenciaBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}