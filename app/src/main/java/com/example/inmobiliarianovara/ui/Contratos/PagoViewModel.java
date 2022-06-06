package com.example.inmobiliarianovara.ui.Contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliarianovara.modelo.Contrato;
import com.example.inmobiliarianovara.modelo.Pago;
import com.example.inmobiliarianovara.request.ApiClientRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagoViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Pago>> pagos;
    private Context context;

    public PagoViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<ArrayList<Pago>> getPagos () {
        if (pagos == null) {
            pagos = new MutableLiveData<>();
        }
        return pagos;
    }
    public void cargarPagos(Bundle bundle) {
        Contrato contrato  = (Contrato) bundle.getSerializable("contrato");
        int contratoId= contrato.getIdContrato();

        ArrayList<Pago> pagosList = new ArrayList<>();
        ApiClientRetrofit.RetrofitService apiClientRetrofit=ApiClientRetrofit.getMyApiClient();
        SharedPreferences sp= ApiClientRetrofit.conectar(context);
        Call<List<Pago>> dato =apiClientRetrofit.PagosContrato(contratoId,sp.getString("token","-1"));
        dato.enqueue(new Callback<List<Pago>>() {
            @Override
            public void onResponse(Call<List<Pago>> call, Response<List<Pago>> response) {
                if (response.isSuccessful()){
                    response.body().forEach(e -> {
                        Pago pago= new Pago(e.getIdPago(),e.getNumero(),e.getContrato(),e.getImporte(),e.getFechaPago());
                        pagosList.add(pago);
                    });

                    pagos.setValue((ArrayList<Pago>) pagosList);
                    Log.d("Exito al obtener pagos",response.toString());
                }

                else {
                    Log.d("Error al cargar pagos",response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Pago>> call, Throwable t) {
                Log.d("Error pagoss",t.toString());
            }

        });
    }



}