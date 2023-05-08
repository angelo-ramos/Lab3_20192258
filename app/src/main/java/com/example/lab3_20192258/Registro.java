package com.example.lab3_20192258;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab3_20192258.Entities.ListPetEmergency;
import com.example.lab3_20192258.Entities.PetEmergency;
import com.example.lab3_20192258.databinding.FragmentBeginBinding;
import com.example.lab3_20192258.databinding.FragmentRegistroBinding;


public class Registro extends Fragment {
    FragmentRegistroBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegistroBinding.inflate(inflater,container,false);

        NavController navController = NavHostFragment.findNavController(Registro.this);
        binding.button.setOnClickListener( view -> {
            Context context = getContext();

            //################################# Guardar Registro #######################################################

            boolean fine = true;

            EditText nomMasco = binding.editTextNomMascota;
            String textStringNomMasc="";
            if(nomMasco.getText().toString().equals("")){
                nomMasco.setError("Debe ingresar un nombre de mascota");
            }else{
                textStringNomMasc=nomMasco.getText().toString();
            }

            Spinner spinnerGenero=binding.spinnerGenero;
            String textGenero=spinnerGenero.getSelectedItem().toString();

            EditText nomDue=binding.editTextNomDue;
            String textnomDue = "";
            if(nomDue.getText().toString().equals("")){
                nomDue.setError("Debe ingresar un nombre de Dueño");
            }else{
                textnomDue=nomDue.getText().toString();
            }

            EditText editTextDni = binding.editTextDni;
            String dnitext = editTextDni.getText().toString();
            int dniint=0;
            if (dnitext.length() == 8){
                dniint = Integer.parseInt(dnitext);
            }else{
                fine = false;
                editTextDni.setError("Insertar 8 dígitos");
            }

            EditText descrip=binding.editTextDesc;
            String textDesc="";
            if(descrip.getText().toString().equals("")){
                descrip.setError("Debe ingresar un nombre de Dueño");
            }else{
                textDesc=descrip.getText().toString();
            }

            //Añadir a la lista
            if(fine) {
                PetEmergency mascotaEmer = new PetEmergency(textStringNomMasc, textGenero, textnomDue, dniint, textDesc,"");
                ListPetEmergency.addMascotaEmergencia(mascotaEmer);
                Toast.makeText(context, "Se guardo con éxito", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.action_registro_to_begin);
            } else{
                Toast.makeText(context, "Tiene que llenar todos los campos", Toast.LENGTH_SHORT).show();
            }

            //###################################################################################################################
        });

        return binding.getRoot();
    }
}