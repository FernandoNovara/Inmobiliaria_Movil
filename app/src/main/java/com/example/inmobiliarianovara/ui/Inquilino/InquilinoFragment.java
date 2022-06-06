package com.example.inmobiliarianovara.ui.Inquilino;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.inmobiliarianovara.R;
import com.example.inmobiliarianovara.modelo.Contrato;
import com.example.inmobiliarianovara.modelo.Inmueble;
import com.example.inmobiliarianovara.modelo.Inquilino;
import com.example.inmobiliarianovara.ui.Inquilino.InquilinoViewModel;

public class InquilinoFragment extends Fragment {

    private InquilinoViewModel inquilinoViewModel;
    private EditText etCodigo,etNombre,etApellido,etDni,etEmail,etTelefonoInquilino,etGarante,etTelefonoGarante;

    public static InquilinoFragment newInstance() {
        return new InquilinoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_inquilino,container,false);
        InicializarVista(root);

        return root;
    }

    public void InicializarVista(View view)
    {
        etCodigo = view.findViewById(R.id.etCodigoInquilino);
        etNombre = view.findViewById(R.id.etNombreInquilino);
        etApellido = view.findViewById(R.id.etApellidoInquilino);
        etDni = view.findViewById(R.id.etDni);
        etEmail = view.findViewById(R.id.etEmailInquilino);
        etTelefonoInquilino = view.findViewById(R.id.etTelefonoInquilino);
        etGarante = view.findViewById(R.id.etNombreGarante);
        etTelefonoGarante = view.findViewById(R.id.etTelefonoGarante);

        inquilinoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoViewModel.class);
        inquilinoViewModel.getInquilino().observe(getActivity(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {
                etCodigo.setText(contrato.getInquilino().getIdInquilino() + " ");
                etNombre.setText(contrato.getInquilino().getNombre());
                etApellido.setText(contrato.getInquilino().getApellido());
                etDni.setText(contrato.getInquilino().getDNI() + " ");
                etEmail.setText(contrato.getInquilino().getEmail());
                etTelefonoInquilino.setText(contrato.getInquilino().getTelefono());
                etGarante.setText(contrato.getInquilino().getNombreGarante());
                etTelefonoGarante.setText(contrato.getInquilino().getTelefonoGarante());
            };

        });
        inquilinoViewModel.cargarInquilino(getArguments());


    }


}