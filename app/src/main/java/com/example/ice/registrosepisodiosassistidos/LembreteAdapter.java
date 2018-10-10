package com.example.ice.registrosepisodiosassistidos;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


class LembreteAdapter extends RecyclerView.Adapter<LembreteAdapter.ViewHolder>{
    private Cursor cursor;
    public LembreteAdapter(Cursor c){
        cursor = c;
    }

    public void setCursor(Cursor c){
        cursor = c;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View livroView = inflater.inflate(R.layout.lembrete_layout, parent, false);
        ViewHolder holder = new ViewHolder(livroView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int idxNomeSerie= cursor.getColumnIndexOrThrow(EpisodioContract.Lembrete.COLUMN_NOME_SERIE);
        int idxNumeroTemporada= cursor.getColumnIndexOrThrow(EpisodioContract.Lembrete.COLUMN_NUMERO_TEMPORADA);
        int idxNumeroEpisodio= cursor.getColumnIndexOrThrow(EpisodioContract.Lembrete.COLUMN_NUMERO_EPISODIO);
        cursor.moveToPosition(position);
        holder.txtNomeSerie.setText(cursor.getString(idxNomeSerie));
        holder.txtNumeroTemporada.setText(cursor.getString(idxNumeroTemporada));
        holder.txtNumeroEpisodio.setText(String.valueOf(cursor.getInt(idxNumeroEpisodio)));
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtNomeSerie;
        public TextView txtNumeroTemporada;
        public TextView txtNumeroEpisodio;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNomeSerie = itemView.findViewById(R.id.txt_nome_serie);
            txtNumeroTemporada = itemView.findViewById(R.id.txt_numero_temporada);
            txtNumeroEpisodio = itemView.findViewById(R.id.txt_numero_episodio);
        }
    }
}
