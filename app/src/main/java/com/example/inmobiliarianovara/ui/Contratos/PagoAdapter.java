package com.example.inmobiliarianovara.ui.Contratos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inmobiliarianovara.R;
import com.example.inmobiliarianovara.modelo.Contrato;
import com.example.inmobiliarianovara.modelo.Pago;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PagoAdapter extends RecyclerView.Adapter<PagoAdapter.ViewHolder> {
    private List<Pago> pagos;
    private Context context;
    private LayoutInflater inflater;
    public Contrato ContratoPago;

    public PagoAdapter( Context context, List<Pago> pago, LayoutInflater inflater) {
        this.context = context;
        this.pagos = pago;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public PagoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_detalle_pago, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvCodigo.setText(pagos.get(position).getIdPago() + "");
        holder.tvNumero.setText(pagos.get(position).getNumero()+"");
        holder.tvCodigoContrato.setText(pagos.get(position).getContrato().getIdContrato()+"");
        holder.tvFecha.setText(pagos.get(position).getFechaPago()+"");
        holder.tvImporte.setText("$" + pagos.get(position).getImporte());
        ContratoPago = pagos.get(position).getContrato();
    }

    @Override
    public int getItemCount() {
        return pagos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCodigo , tvNumero, tvCodigoContrato, tvImporte, tvFecha;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCodigoContrato = itemView.findViewById(R.id.tvCodigoContrato);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvNumero = itemView.findViewById(R.id.tvNumero);
            tvImporte = itemView.findViewById(R.id.tvImporte);
            tvFecha = itemView.findViewById(R.id.tvFecha);

        }
    }
}
