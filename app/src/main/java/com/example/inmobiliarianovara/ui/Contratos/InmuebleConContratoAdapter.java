package com.example.inmobiliarianovara.ui.Contratos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.inmobiliarianovara.R;
import com.example.inmobiliarianovara.modelo.Contrato;
import com.example.inmobiliarianovara.modelo.Inmueble;

import java.util.List;

public class InmuebleConContratoAdapter extends RecyclerView.Adapter<InmuebleConContratoAdapter.ViewHolder> {

    private List<Inmueble> inmuebles;
    private Context context;
    private LayoutInflater inflater;
    private List<Contrato> contratos;

    public InmuebleConContratoAdapter(Context context, List<Contrato> contratos, LayoutInflater inflater) {
        this.context = context;
        this.contratos = contratos;
        this.inflater = inflater;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_inmueble_alquilado_fragment, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDireccion.setText(contratos.get(position).getInmueble().getDireccion());

        Glide.with(context)
                .load(contratos.get(position).getInmueble().getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivImagenInmueble);

    }

    @Override
    public int getItemCount() {
        return contratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDireccion;
        ImageView ivImagenInmueble;
        Button btnVer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagenInmueble = itemView.findViewById(R.id.ivImagenInmueble);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            btnVer = itemView.findViewById(R.id.btnVer);
            btnVer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Contrato contrato = contratos.get(getAdapterPosition());
                    bundle.putSerializable("contrato", contrato);
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.detalleContrato , bundle);
                }
            });
        }
    }
}
