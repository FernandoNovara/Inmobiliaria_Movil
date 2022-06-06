package com.example.inmobiliarianovara.ui.Inmuebles;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.inmobiliarianovara.modelo.Inmueble;
import com.example.inmobiliarianovara.request.ApiClientRetrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmueblesViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private Context context;

    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void cargarInmuebles() {

        SharedPreferences sp = ApiClientRetrofit.conectar(context);
        Log.d("sp",sp.getString("token","-1"));
        ApiClientRetrofit.RetrofitService apiClientRetrofit = ApiClientRetrofit.getMyApiClient();
        Call<ArrayList<Inmueble>> dato = apiClientRetrofit.listaDeInmuebles(sp.getString("token","-1"));
        dato.enqueue(new Callback<ArrayList<Inmueble>>() {
            @Override
            public void onResponse(Call<ArrayList<Inmueble>> call, Response<ArrayList<Inmueble>> response)
            {
                 if (response.isSuccessful())
                 {
                     inmuebles.setValue(response.body());
                 }
            }

            @Override
            public void onFailure(Call<ArrayList<Inmueble>> call, Throwable t)
            {

            }
        });
    }



}