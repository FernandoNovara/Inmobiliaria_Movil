package com.example.inmobiliarianovara.ui.Inquilino;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliarianovara.modelo.Contrato;

public class InquilinoViewModel extends AndroidViewModel {

    private MutableLiveData<Contrato> inquilino;

    public InquilinoViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Contrato> getInquilino()
    {
        if (inquilino == null) {
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInquilino(Bundle bundle) {
        Contrato contrato = (Contrato) bundle.getSerializable("contrato");
        this.inquilino.setValue(contrato);


    }

}