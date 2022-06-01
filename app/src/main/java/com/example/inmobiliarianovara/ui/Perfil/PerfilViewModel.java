package com.example.inmobiliarianovara.ui.Perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliarianovara.modelo.Propietario;
import com.example.inmobiliarianovara.request.ApiClientRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> estado;
    private MutableLiveData<String> textoBoton;
    private Propietario propietario;
    private Context context;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<Boolean> getEstado() {
        if (estado == null) {
            estado = new MutableLiveData<>();
        }
        return estado;
    }

    public LiveData<String> getTextoBoton() {
        if (textoBoton == null) {
            textoBoton = new MutableLiveData<>();
        }
        return textoBoton;
    }

       public LiveData<Propietario> getUsuario() {
        if (usuario == null) {
            usuario = new MutableLiveData<>();
        }
        return usuario;
    }

    public void accionBoton(String txtBoton, Propietario propietario)
    {
        if(txtBoton.equals("Editar"))
        {
            textoBoton.setValue("Guardar");
            estado.setValue(true);
        }
        else
        {
            textoBoton.setValue("Editar");
            estado.setValue(false);
            //api.actualizarPerfil(propietario);
        }
    }

    public void traerDatos()
    {
        ApiClientRetrofit.RetrofitService api = ApiClientRetrofit.getMyApiClient();
        SharedPreferences sp = ApiClientRetrofit.conectar(context);
        Call<Propietario> dato = api.Perfil(sp.getString("token","-1"));
        dato.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response)
            {
                if (response.isSuccessful())
                {
                    Propietario p = new Propietario(response.body().getId(),response.body().getDni(),response.body().getNombre(),
                            response.body().getApellido(),response.body().getEmail(),response.body().getContraseña(),response.body().getTelefono());
                    propietario.setValue(p);
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) { }
        });
    }

}