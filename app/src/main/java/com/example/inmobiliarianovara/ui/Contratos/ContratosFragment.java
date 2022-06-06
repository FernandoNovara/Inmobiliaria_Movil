package com.example.inmobiliarianovara.ui.Contratos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.inmobiliarianovara.R;
import com.example.inmobiliarianovara.modelo.Contrato;
import com.example.inmobiliarianovara.modelo.Inmueble;

import java.util.ArrayList;

public class ContratosFragment extends Fragment {

    private ContratosViewModel contratosViewModel;
    private RecyclerView rvContratos;
    private InmuebleConContratoAdapter adapter;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contratos, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }



    private void inicializar(View view) {
        rvContratos = view.findViewById(R.id.rvContratos);
        contratosViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication()).create(ContratosViewModel.class);
        contratosViewModel.getContrato().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
            @Override
            public void onChanged(ArrayList<Contrato> contratos)
            {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
                rvContratos.setLayoutManager(gridLayoutManager);
                adapter = new InmuebleConContratoAdapter(context, contratos, getLayoutInflater());
                rvContratos.setAdapter(adapter);
            }
        });
       contratosViewModel.cargarInmueblesConContrato();
    }




}