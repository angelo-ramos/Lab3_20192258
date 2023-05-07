package com.example.lab3_20192258;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lab3_20192258.databinding.FragmentBeginBinding;

import java.util.ArrayList;


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
        binding.Emergencia.setOnClickListener( view -> {
            navController.navigate(R.id.action_begin_to_emergencia);
        });
        binding.Historial.setOnClickListener( view -> {
            navController.navigate(R.id.action_begin_to_historial);
        });

        return binding.getRoot();
    }
}