package com.example.lab3_20192258;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab3_20192258.databinding.FragmentBeginBinding;


public class Begin extends Fragment {
    FragmentBeginBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBeginBinding.inflate(inflater,container,false);

        NavController navController = NavHostFragment.findNavController(Begin.this);
        binding.Registro.setOnClickListener( view -> {
            navController.navigate(R.id.action_begin_to_registro);
        });

        return binding.getRoot();
    }
}