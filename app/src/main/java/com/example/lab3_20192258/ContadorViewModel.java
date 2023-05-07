package com.example.lab3_20192258;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContadorViewModel extends ViewModel {

    private MutableLiveData<Integer> contador = new MutableLiveData<>();
    private Thread thread = null;

    public void contarNto0(int n) {
        thread = new Thread(() -> {
            int i = n;
            while (i >= 0) {
                contador.postValue(i);

                i--;

                try {
                    Thread.sleep(1000); //Acelerado, revertir luego
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public MutableLiveData<Integer> getContador() {
        return contador;
    }

    public void setContador(MutableLiveData<Integer> contador) {
        this.contador = contador;
    }
}
