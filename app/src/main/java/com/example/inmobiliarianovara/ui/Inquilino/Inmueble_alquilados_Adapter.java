package com.example.inmobiliarianovara.ui.Inquilino;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Inmueble_alquilados_Adapter extends RecyclerView.Adapter<Inmueble_alquilados_Adapter.ViewHolder> {
    private Context context;
    private List<Inmueble> inmuebles;
    private LayoutInflater inflater;
    private List<Contrato> contratos;



    public Inmueble_alquilados_Adapter(Context context, List<Contrato> contratos, LayoutInflater inflater) {
        this.context = context;
        this.inmuebles = inmuebles;
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
        holder.tvDireccionAlquilado.setText(contratos.get(position).getInmueble().getDireccion());
        Glide.with(context)
                .load(contratos.get(position).getInmueble().getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivImagenInmuebleAlquilado);

    }

    @Override
    public int getItemCount() {
        return contratos.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDireccionAlquilado;
        ImageView ivImagenInmuebleAlquilado;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagenInmuebleAlquilado = itemView.findViewById(R.id.ivImagenInmueble);
            tvDireccionAlquilado = itemView.findViewById(R.id.tvDireccion);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Contrato contrato = contratos.get(getAdapterPosition());
                    bundle.putSerializable("contrato", contrato);
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.nav_inquilino, bundle);
                }
            });
        }
    }
}







