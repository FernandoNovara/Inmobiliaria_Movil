package com.example.inmobiliarianovara.ui.Contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.inmobiliarianovara.modelo.Contrato;
import com.example.inmobiliarianovara.request.ApiClientRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratosViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Contrato>> contratos;
    private Context context;

    public ContratosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Contrato>> getContrato() {
        if (contratos == null) {
            contratos = new MutableLiveData<>();
        }
        return contratos;
    }


    public void cargarInmueblesConContrato() {

        ArrayList<Contrato> listaContratos = new ArrayList<>();
        SharedPreferences sp = ApiClientRetrofit.conectar(context);
        ApiClientRetrofit.RetrofitService apiClientRetrofit = ApiClientRetrofit.getMyApiClient();

        Call<List<Contrato>> dato = apiClientRetrofit.ObtenerContratos(sp.getString("token","-1"));
        dato.enqueue(new Callback<List<Contrato>>() {
            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response)
            {
                if (response.isSuccessful())
                {
                    response.body().forEach(e ->
                    {
                        Contrato contrato = new Contrato(e.getIdContrato(),
                                                        e.getFechaInicio(),
                                                        e.getFechaFin(),
                                                        e.getMontoAlquiler(),
                                                        e.getInquilino(),
                                                        e.getInmueble());
                        listaContratos.add(contrato);
                    });
                    contratos.setValue((ArrayList<Contrato>) listaContratos);
            }
                else
                {
                    Log.d("No entro a contratos",response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t)
            {
                Log.d("Error",t.getMessage());
            }
        });
    }


}
