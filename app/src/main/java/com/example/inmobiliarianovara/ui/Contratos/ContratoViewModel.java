package com.example.inmobiliarianovara.ui.Contratos;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliarianovara.modelo.Contrato;

public class ContratoViewModel extends AndroidViewModel {

    private MutableLiveData<Contrato> contrato;


    public ContratoViewModel(@NonNull Application application)
    {
        super(application);
    }

    public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }



    public void cargarContrato(Bundle bundle) {

        Contrato contrato = (Contrato) bundle.getSerializable("contrato");
        this.contrato.setValue(contrato);
    }


}

