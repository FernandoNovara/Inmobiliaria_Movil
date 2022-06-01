package com.example.inmobiliarianovara.ui.Contratos;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliarianovara.modelo.Contrato;
import com.example.inmobiliarianovara.modelo.Inmueble;
import com.example.inmobiliarianovara.request.ApiClient;

public class ContratoViewModel extends AndroidViewModel {

    private MutableLiveData<Contrato> contrato;

    public ContratoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }

    public void cargarContrato(Bundle bundle) {
        ApiClient apiClient= ApiClient.getApi();
        Inmueble inmueble = (Inmueble) bundle.get("inmueble");
        Contrato contrato=apiClient.obtenerContratoVigente(inmueble);

        this.contrato.setValue(contrato);
    }


}

