package com.example.inmobiliarianovara.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.inmobiliarianovara.modelo.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.util.*;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public class ApiClientRetrofit {

    private static final String URLBASE="http://192.168.1.104:5000/api/";
    private static RetrofitService myApiInterface;
    private static SharedPreferences sp;

    public static SharedPreferences conectar(Context context)
    {
        if(sp == null)
        {
            sp=context.getSharedPreferences("Datos",0);
        }
        return sp;

    }

    public static RetrofitService getMyApiClient()
    {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLBASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInterface=retrofit.create(RetrofitService.class);

        return myApiInterface;
    }



    public interface RetrofitService
    {
        //login
        @POST("Propietario/login")
        Call<String> login(@Body Usuario usuario);

        //Perfil
        @GET("Propietario")
        Call<Propietario> Perfil(@Header("Authorization") String token);

        //Editar Perfil
        @PUT("Propietario")
        Call<Propietario> EditarPerfil(@Body Propietario propietario,@Header("Authorization") String token);


        //obtener inmuebles
        @GET("Inmueble")
        Call<ArrayList<Inmueble>> listaDeInmuebles(@Header("Authorization") String token);

        //Obtener inmuebles por id
        @GET("Inmueble/{id}")
        Call<Inmueble> inmuebleXId(@Path("id") int id, @Header ("Authorization") String token);

        //Obtener Contrato por id de inmueble
        @GET("Contrato/{id}")
        Call<List<Contrato>> obtenerContratoVigente(@Path("id") int id, @Header ("Authorization") String token);

        //Obtener Contratos de Propietario logueado
        @GET("Contrato")
        Call<List<Contrato>> ObtenerContratos(@Header ("Authorization") String token);

        //Obtener Inquilinos por id de contrato
        @GET("Inquilino/{id}")
        Call<Inquilino> ObtenerInquilinos(@Path("id") int id,@Header ("Authorization") String token);

        //Pago
        @GET("Pagos/{id}")
        Call<List<Pago>> PagosContrato (@Path("id") int id ,@Header("Authorization") String token);

    }

}

