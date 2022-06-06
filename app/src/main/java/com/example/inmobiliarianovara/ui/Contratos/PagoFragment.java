package com.example.inmobiliarianovara.ui.Contratos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inmobiliarianovara.R;
import com.example.inmobiliarianovara.modelo.Pago;
import java.util.ArrayList;

public class PagoFragment extends Fragment {

    private RecyclerView rvPagoContrato;
    private Context context;
    private PagoAdapter adapter;
    private PagoViewModel pagoViewModel;

    public static PagoFragment newInstance() {
        return new PagoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.detalle_contrato_fragment, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view)
    {
        rvPagoContrato = view.findViewById(R.id.rvPagoContrato);
        pagoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagoViewModel.class);
        pagoViewModel.getPagos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Pago>>() {
            @Override
            public void onChanged(ArrayList<Pago> pagos) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1,GridLayoutManager.VERTICAL,false);
                rvPagoContrato.setLayoutManager(gridLayoutManager);
                adapter = new PagoAdapter(context, pagos, getLayoutInflater());
                rvPagoContrato.setAdapter(adapter);
            }
        });
        pagoViewModel.cargarPagos(getArguments());

    }

}