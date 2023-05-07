package com.example.lab3_20192258.Entities;

import java.util.ArrayList;

public class ListPetEmergency {

    public static ArrayList<PetEmergency> listaMastEmergencia=new ArrayList<>();
    public static ArrayList<PetEmergency> getListaMastEmergencia(){
        return listaMastEmergencia;
    }
    //to add new pet in emergency
    public static void addMascotaEmergencia(PetEmergency mascotaEmergencia){
        listaMastEmergencia.add(mascotaEmergencia);
    }


    public static ArrayList<SourDest> listaOrigenDestino=new ArrayList<>();
    public static ArrayList<SourDest> getListaOrigenDestino(){
        return listaOrigenDestino;
    }
}
