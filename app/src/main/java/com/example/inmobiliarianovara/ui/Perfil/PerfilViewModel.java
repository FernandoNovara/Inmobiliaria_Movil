package com.example.inmobiliarianovara.ui.Perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

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

    private MutableLiveData<Boolean> MutableEstado;
    private MutableLiveData<String> MutableTextoBoton;
    private MutableLiveData<Propietario> MutablePropietario;
    private MutableLiveData<String> MutableMensaje;
    private Context context;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<Boolean> getEstado() {
        if (MutableEstado == null) {
            MutableEstado = new MutableLiveData<>();
        }
        return MutableEstado;
    }

    public LiveData<String> getTextoBoton() {
        if (MutableTextoBoton == null) {
            MutableTextoBoton = new MutableLiveData<>();
        }
        return MutableTextoBoton;
    }

       public LiveData<Propietario> getUsuario() {
        if (MutablePropietario == null) {
            MutablePropietario = new MutableLiveData<>();
        }
        return MutablePropietario;
    }

    public LiveData<String> getMensaje() {
        if (MutableMensaje == null) {
            MutableMensaje = new MutableLiveData<>();
        }
        return MutableMensaje;
    }

    public void accionBoton(String txtBoton, Propietario propietario) {
        if (txtBoton.equals("Editar")) {
            MutableTextoBoton.setValue("Guardar");
            MutableEstado.setValue(true);
        } else {
            MutableTextoBoton.setValue("Editar");
            MutableEstado.setValue(false);
            SharedPreferences sp = ApiClientRetrofit.conectar(context);
            Log.d("sp",sp.getString("token","-1"));
            ApiClientRetrofit.RetrofitService apiClient = ApiClientRetrofit.getMyApiClient();
            Call<Propietario> dato = apiClient.EditarPerfil(propietario, sp.getString("token", "-1"));
            dato.enqueue(new Callback<Propietario>() {

                @Override
                public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                    if (response.isSuccessful()) {
                        MutableMensaje.setValue("Usuario Actulizado correctamente");
                    } else {
                        Log.d("Error de actulizacion", response.toString());
                        MutableMensaje.setValue("Usuario no se pudo actualizar");
                    }

                }

                @Override
                public void onFailure(Call<Propietario> call, Throwable t) {
                    Log.d("Error de actulizacion", t.toString());
                }

            });
        }
    }

    public void traerDatos()
    {
        SharedPreferences sp = ApiClientRetrofit.conectar(context);
        Log.d("sp",sp.getString("token","-1"));
        ApiClientRetrofit.RetrofitService apiClientRetrofit = ApiClientRetrofit.getMyApiClient();
        Call<Propietario> dato = apiClientRetrofit.Perfil(sp.getString("token","-1"));
        dato.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response)
            {
                if (response.isSuccessful())
                {
                    Propietario p = new Propietario(response.body().getId(),response.body().getNombre(),response.body().getApellido(),
                            response.body().getDni(), response.body().getEmail(),response.body().getTelefono(),response.body().getContraseña());
                    MutablePropietario.setValue(p);
                }
                else
                {
                    Log.d("Error login",response.toString());
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t)
            {
                Log.d("Token",t.getMessage());
            }
        });
    }

}