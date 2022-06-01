package com.example.inmobiliarianovara;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliarianovara.modelo.Usuario;
import com.example.inmobiliarianovara.request.ApiClientRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> mensaje;
    private MutableLiveData<String> token;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<String> getMensaje() {
        if (mensaje == null) {
            mensaje = new MutableLiveData<>();
        }
        return mensaje;
    }

    public LiveData<String> token()
    {
        if (token == null)
        {
            token = new MutableLiveData<>();
        }
        return token;
    }

    public void iniciarSesion(String usuario,String password)
    {
        Usuario user = new Usuario(usuario,password);
        SharedPreferences sp = ApiClientRetrofit.conectar(context);
        ApiClientRetrofit.RetrofitService api = ApiClientRetrofit.getMyApiClient();
        Call<String> dato=api.login(user);
        dato.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful())
                {
                    Log.d("token",response.toString());

                    SharedPreferences.Editor editor = sp.edit();
                    String token = "Bearer" + response.body();
                    editor.putString("token",token);
                    editor.commit();
                    Log.d("Sp",sp.getString("token","-1"));

                    Log.d("token",token);
                    Intent intent = new Intent(context,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else
                {
                    Log.d("Error de logueo",response.toString());
                    mensaje.setValue("Usuario y/o Contraseña incorrecto!");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("Error de Conexion",t.toString());
            }
        });

    }
}
