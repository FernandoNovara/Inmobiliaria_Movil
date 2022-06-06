package com.example.inmobiliarianovara.ui.Inquilino;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliarianovara.modelo.Contrato;
import com.example.inmobiliarianovara.modelo.Inmueble;
import com.example.inmobiliarianovara.modelo.Inquilino;
import com.example.inmobiliarianovara.request.ApiClientRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmueblesAlquiladosViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private MutableLiveData<ArrayList<Contrato>> contratos;
    private MutableLiveData<Inquilino> inquilino;
    private Context context;

    public InmueblesAlquiladosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }
    public LiveData<Inquilino> getInquilino() {
        if (inquilino == null) {
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }
    public LiveData<ArrayList<Contrato>> getContratos() {
        if (contratos == null) {
            contratos = new MutableLiveData<>();
        }
        return contratos;
    }

    public void cargarInmueblesAlquilados() {
        ArrayList<Contrato> listaContrato = new ArrayList<>();
        ApiClientRetrofit.RetrofitService apiClientRetrofit=ApiClientRetrofit.getMyApiClient();
        SharedPreferences sp= ApiClientRetrofit.conectar(context);
        Call<List<Contrato>> dato =apiClientRetrofit.ObtenerContratos(sp.getString("token","-1"));
        dato.enqueue(new Callback<List<Contrato>>() {
            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {
                if (response.isSuccessful()){
                    response.body().forEach(e -> {
                        Contrato contrato= new Contrato(e.getIdContrato(),e.getFechaInicio(),e.getFechaFinal(),
                                e.getInmueble().getPrecio(),e.getInquilino(), e.getInmueble(),e.getGarante());
                                listaContrato.add(contrato);
                    });

                    contratos.setValue((ArrayList<Contrato>) listaContrato);
                    Log.d("Exito Contratos desde inquilinos",response.toString());
                }

                else {
                    Log.d("Error al cargar contratos",response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                Log.d("Error",t.toString());
            }

        });

    }


}