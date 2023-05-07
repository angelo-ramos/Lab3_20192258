package com.example.lab3_20192258;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab3_20192258.Entities.ListPetEmergency;
import com.example.lab3_20192258.Entities.PetEmergency;
import com.example.lab3_20192258.databinding.FragmentEmergenciaBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Emergencia extends Fragment implements OnMapReadyCallback {
    private double destinolat = 0.0;
    private double destinolong = 0.0;
    private final LatLng ORIGEN = new LatLng(-12.084538, -77.031396);
    private int minutos;
    private int hor,min,seg;
    private String lat,lon;
    FragmentEmergenciaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEmergenciaBinding.inflate(inflater,container,false);

        //########################## Cargar Mapa en el fragment ########################################################################################
        // Get the FragmentManager for the child fragments
        FragmentManager childFragmentManager = getChildFragmentManager();
        // Begin a FragmentTransaction
        FragmentTransaction transaction = childFragmentManager.beginTransaction();
        // Create the nested fragment and add it to the container fragment
        MapFragment nestedFragment = new MapFragment();
        transaction.add(R.id.frame_layout, nestedFragment);
        // Commit the FragmentTransaction
        transaction.commit();
        //###########################################################################################################################################


        //########################## Contador ########################################################################################
        TextView textViewContador = binding.contador;
        ContadorViewModel contadorViewModel = new ViewModelProvider(this).get(ContadorViewModel.class);
        contadorViewModel.getContador().observe((LifecycleOwner) getContext(),
                contador -> {
                    if (contador > 0) {
                        seg=contador;
                        hor=seg/3600;
                        seg %=3600;
                        min =seg/60;
                        seg %=60;
                        textViewContador.setText("La ambulancia llegará en "+hor+"h "+min+"m "+seg+"s");
                    } else {
                        textViewContador.setText("La ambulancia ha llegado a su destino");
                    }
                });
        //#################################################################################################################################



        //########################## Boton calcular ###########################################################################################
        binding.Calcular.setOnClickListener( view -> {
            Geocoder geocoder = new Geocoder(getContext());
            List<Address>  addressList;
            EditText editTextDestin = binding.Destino;
            EditText editTextDni=binding.DNI;
            TextView textView = binding.contador;
            Boolean validacion=true;
            Boolean dniEncon=false;
            //validacion de datos

            if(editTextDestin.getText().toString().equals("")){
                editTextDestin.setError("Debe ingresar un destino");
                validacion=false;
            }
            if (!editTextDestin.getText().toString().contains("Lince") &&
                    !editTextDestin.getText().toString().contains("San Isidro") &&
                    !editTextDestin.getText().toString().contains("Magdalena") &&
                    !editTextDestin.getText().toString().contains("Jesus Maria")){
                editTextDestin.setError("El destino ingresado no es valido");
                validacion=false;
            }

            if(editTextDni.getText().toString() == null || editTextDni.getText().toString().length() != 8 || editTextDni.getText().toString().equals("")){
                editTextDni.setError("Debe ingresar un dni valida de 8 caracteres");
                validacion=false;
            }

            //validacion de que exista el dni en el registro
            ArrayList<PetEmergency> list= ListPetEmergency.getListaMastEmergencia();

            for (PetEmergency obj:list){
                if(editTextDni.getText().toString().equals(Integer.toString(obj.getDNI()))){
                    dniEncon=true;
                }
            }

            if (!dniEncon) {
                editTextDni.setError("DNI no registrado");
                validacion = false;
            }

            if(dniEncon && validacion){
                //asignacion de la ruta a la mascota
                for (PetEmergency obj:list){
                    if(editTextDni.getText().toString().equals(Integer.toString(obj.getDNI()))){
                        obj.setRuta("Origen:Lince - " +"Destino:"+editTextDestin.getText().toString());

                    }
                }
                //seteo del tiempo de viaje (contador)
                if(editTextDestin.getText().toString().contains("Lince")){
                    minutos=10;
                }
                if(editTextDestin.getText().toString().contains("San Isidro")){
                    minutos=15;
                }
                if(editTextDestin.getText().toString().contains("Magdalena")){
                    minutos=20;
                }
                if(editTextDestin.getText().toString().contains("Jesus Maria")){
                    minutos=25;
                }
                //ContadorViewModel contadorViewModel = new ViewModelProvider(this).get(ContadorViewModel.class);
                contadorViewModel.contarNto0(minutos*60);
            }

            try {
                System.out.println(editTextDestin.getText().toString());
                addressList = geocoder.getFromLocationName(editTextDestin.getText().toString(), 1);

                if (addressList != null){
                    destinolat = addressList.get(0).getLatitude();
                    destinolong = addressList.get(0).getLongitude();

                    String latlon=String.valueOf(destinolat) +","+String.valueOf(destinolong);
                    lat=String.valueOf(destinolat);
                    lon=String.valueOf(destinolong);
                    Log.d("msg",lat+lon);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        //########################################################################################################################

        return binding.getRoot();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        googleMap.addMarker(new MarkerOptions()
                .position(ORIGEN)
                .title("Clínica Mascotín"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ORIGEN,12));

        if(destinolat!=0.0 && destinolong!=0.0){
            LatLng destino = new LatLng(destinolat, destinolong);
            googleMap.addMarker(new MarkerOptions()
                    .position(destino)
                    .title("Marker in Sydney"));
        }
    }
}