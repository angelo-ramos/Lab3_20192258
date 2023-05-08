package com.example.lab3_20192258;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab3_20192258.Entities.ListPetEmergency;
import com.example.lab3_20192258.Entities.PetEmergency;
import com.example.lab3_20192258.databinding.FragmentEmergenciaBinding;
import com.example.lab3_20192258.databinding.FragmentHistorialBinding;

import java.util.ArrayList;


public class Historial extends Fragment {
    HistorialAdapter historialAdapter = new HistorialAdapter();
    FragmentHistorialBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistorialBinding.inflate(inflater,container,false);
        ArrayList<PetEmergency> listmodifi= ListPetEmergency.getListaMastEmergencia();
        for(PetEmergency masc: listmodifi){
            if(masc.getRuta().equals("")){
                listmodifi.remove(masc);
            }
        }
        PetEmergency mascota1 = new PetEmergency("Foster", "Masculino", "David", 74931022, "Nada","Origen:Lince-Destino:Lince");
        PetEmergency mascota2 = new PetEmergency("Luna", "Masculino", "Pablo", 74931021, "Enferma","Origen:Lince-Destino:San Isidro");
        PetEmergency mascota3 = new PetEmergency("Tamara", "Femenino", "Javier", 74931024, "Agitada","Origen:Lince-Destino:Magdalena");
        PetEmergency mascota4 = new PetEmergency("Chester", "Masculino", "Pedro", 74931025, "Cansada","Origen:Lince-Destino:Jesus Maria");
        listmodifi.add(mascota1);
        listmodifi.add(mascota2);
        listmodifi.add(mascota3);
        listmodifi.add(mascota4);

        if(listmodifi.size()==0) {
            TextView msjehistorial = binding.textViewMsjehistorial;
            msjehistorial.setVisibility(msjehistorial.VISIBLE);
        }
        historialAdapter.setListaMascotas(listmodifi);
        historialAdapter.setContext(getContext());

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setAdapter(historialAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return binding.getRoot();
    }
}