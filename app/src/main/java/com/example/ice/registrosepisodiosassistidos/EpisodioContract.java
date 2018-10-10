package com.example.ice.registrosepisodiosassistidos;

import android.provider.BaseColumns;

public final class EpisodioContract {
    public final class Lembrete implements BaseColumns {
        public final static String TABLE_NAME = "Lembrete";
        public final static String COLUMN_NOME_SERIE= "nome_serie";
        public final static String COLUMN_NUMERO_TEMPORADA= "numero_temporada";
        public final static String COLUMN_NUMERO_EPISODIO= "numero_episodio";

        public final static String CREATE_LIVRO  = "CREATE TABLE "+ Lembrete.TABLE_NAME+" ("
                + Lembrete._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Lembrete.COLUMN_NOME_SERIE+ " TEXT, "
                + Lembrete.COLUMN_NUMERO_TEMPORADA+ " INTEGER,"
                + Lembrete.COLUMN_NUMERO_EPISODIO+ " INTEGER"
                +")";
        public final static String DROP_LIVRO = "DROP TABLE IF EXISTS "+ Lembrete.TABLE_NAME;
    }
}
