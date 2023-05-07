package com.example.lab3_20192258;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab3_20192258.databinding.FragmentBeginBinding;
import com.example.lab3_20192258.databinding.FragmentRegistroBinding;


public class Registro extends Fragment {
    FragmentRegistroBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegistroBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}