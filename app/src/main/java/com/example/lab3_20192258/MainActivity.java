package com.example.lab3_20192258;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.lab3_20192258.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private NavController navController; //Para el botón atrás del toolbar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Las 3 líneas del binding para un Activity (Para fragment es ligeramente distinto ps son 2)
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Para poner boton atras en cada fragment, poner estas 2 líneas (el nav_host .. esta en activity_main.xml y es un fragment!)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }



    //Método para la navegación hacia atrás (Sirve para el botón hacia atrás)
    @Override
    public boolean onSupportNavigateUp() {
        // Handle the back button event
        return NavigationUI.navigateUp(navController, (DrawerLayout) null);
    }
}