package com.example.inmobiliarianovara.ui.Contratos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


import com.example.inmobiliarianovara.R;
import com.example.inmobiliarianovara.modelo.Contrato;

import java.text.DateFormat;

public class ContratoFragment extends Fragment {

    private ContratoViewModel contratoViewModel;
    private EditText etCodigoContrato;
    private EditText etFechaInicio;
    private EditText etFechaFin;
    private EditText etMontoAlquiler;
    private EditText etInquilino;
    private EditText etInmueble;
    private Button btPagos;
    private Context context;

    public static ContratoFragment newInstance() {
        return new ContratoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.detalle_contrato_fragment, container, false);

        inicializar(root);

        return root;
    }

    private void inicializar(View view) {
        etCodigoContrato = view.findViewById(R.id.etCodigoContrato);
        etFechaInicio = view.findViewById(R.id.etFechaInicio);
        etFechaFin = view.findViewById(R.id.etFechaFinal);
        etMontoAlquiler = view.findViewById(R.id.etDniInquilino);
        etInquilino = view.findViewById(R.id.etEmail);
        etInmueble = view.findViewById(R.id.etInmueble);
        btPagos=view.findViewById(R.id.btnPagos);

        contratoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoViewModel.class);

        contratoViewModel.getContrato().observe(getActivity(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato)
            {
                etCodigoContrato.setText(contrato.getIdContrato() + "");
                etFechaInicio.setText(contrato.getFechaInicioCorta());
                etFechaFin.setText(contrato.getFechaFinalCorta());
                etMontoAlquiler.setText("$" + contrato.getInmueble().getPrecio());
                etInquilino.setText(contrato.getInquilino().getNombre());
                etInmueble.setText(contrato.getInmueble().getDireccion());
            }
        });

        btPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contrato contrato = new Contrato();
                contrato.setIdContrato(Integer.parseInt(etCodigoContrato.getText().toString()));
                Bundle bundle = new Bundle();
                bundle.putSerializable("contrato", contrato);
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.PagoFragment, bundle);
            }
        });

        contratoViewModel.cargarContrato(getArguments());


    }
}