package com.example.lab3_20192258;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3_20192258.Entities.PetEmergency;

import java.util.ArrayList;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder> {
        private Context context;

        public Context getContext() {
                return context;
        }

        public void setContext(Context context) {
                this.context = context;
        }

        public ArrayList<PetEmergency> getListaMascotas() {
                return listaMascotas;
        }

        public void setListaMascotas(ArrayList<PetEmergency> listaMascotas) {
                this.listaMascotas = listaMascotas;
        }

        private ArrayList<PetEmergency> listaMascotas;



        public class HistorialViewHolder extends RecyclerView.ViewHolder{
                PetEmergency mascotaEmergencia;
                public HistorialViewHolder(@NonNull View itemView) {
                        super(itemView);
                }
        }


        @NonNull
        @Override
        public HistorialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(context).inflate(R.layout.icrv_historial, parent, false);
                return new HistorialViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull HistorialViewHolder holder, int position) {
                PetEmergency mascotaEmergencia = listaMascotas.get(position);
                holder.mascotaEmergencia = mascotaEmergencia;
                TextView mascota_text = holder.itemView.findViewById(R.id.mascota_text);
                TextView genero_text = holder.itemView.findViewById(R.id.genero_text);
                TextView dueno_text = holder.itemView.findViewById(R.id.dueno_text);
                TextView dni_text = holder.itemView.findViewById(R.id.dni_text);
                TextView descrip_text = holder.itemView.findViewById(R.id.descrip_text);
                TextView ruta_tex = holder.itemView.findViewById(R.id.ruta_text);

                mascota_text.setText(mascotaEmergencia.getNombreMasc());
                genero_text.setText(mascotaEmergencia.getGeneroMasc());
                dueno_text.setText(mascotaEmergencia.getNombreDuenho());
                dni_text.setText(Integer.toString(mascotaEmergencia.getDNI()));
                descrip_text.setText(mascotaEmergencia.getDescripcion());
                ruta_tex.setText(mascotaEmergencia.getRuta());

        }

        @Override
        public int getItemCount() {
                return listaMascotas.size();
        }
}
