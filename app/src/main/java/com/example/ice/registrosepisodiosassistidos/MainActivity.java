package com.example.ice.registrosepisodiosassistidos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnInserir;
    private Button btnListar;
    private RecyclerView rclEpisodios;
    private EpisodioDbHelper dbHelper;
    private LembreteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new EpisodioDbHelper(getApplicationContext());

        rclEpisodios = (RecyclerView) findViewById(R.id.rcl_episodios);
        rclEpisodios.setLayoutManager(new LinearLayoutManager(this));

        adapter = new LembreteAdapter(getCursorLivrosPos1950());
        rclEpisodios.setAdapter(adapter);




        final Random rnd = new Random();
        btnInserir = (Button) findViewById(R.id.btn_incluir);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues valores = new ContentValues();
                /*valores.put(EpisodioContract.Lembrete.COLUMN_NOME_SERIE, "nome_serie "+rnd.nextInt(1000));
                valores.put(EpisodioContract.Lembrete.COLUMN_NUMERO_TEMPORADA, "numero_temporada "+rnd.nextInt(1000));
                valores.put(EpisodioContract.Lembrete.COLUMN_NUMERO_EPISODIO, 1900+rnd.nextInt(118));
                long id = db.insert(EpisodioContract.Lembrete.TABLE_NAME,null, valores);
                Log.i("DBINFO", "registro criado com id: "+id);
                adapter.setCursor(getCursorLivrosPos1950());*/
            }
        });
        /*btnListar = (Button) findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = getCursorLivrosPos1950();
                cursor.moveToPosition(-1);
                while(cursor.moveToNext()) {
                    int idxTitulo = cursor.getColumnIndexOrThrow(BibliotecaContract.Livro.COLUMN_NAME_TITULO);
                    int idxAutor = cursor.getColumnIndexOrThrow(BibliotecaContract.Livro.COLUMN_NAME_AUTOR);
                    int idxAno = cursor.getColumnIndexOrThrow(BibliotecaContract.Livro.COLUMN_NAME_ANO);
                    String titulo = cursor.getString(idxTitulo);
                    String autor = cursor.getString(idxAutor);
                    Integer ano = cursor.getInt(idxAno);
                    Log.i("DBINFO", "titulo: " + titulo+" autor: "+autor+" ano:"+ ano);
                }
            }
        });*/
    }

    private Cursor getCursorLivrosPos1950() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] visao = {
                EpisodioContract.Lembrete.COLUMN_NOME_SERIE,
                EpisodioContract.Lembrete.COLUMN_NUMERO_TEMPORADA,
                EpisodioContract.Lembrete.COLUMN_NUMERO_EPISODIO
        };
        String restricoes = EpisodioContract.Lembrete.COLUMN_NUMERO_EPISODIO + " > ?";
        String[] params = {"1950"};
        String sort = EpisodioContract.Lembrete.COLUMN_NOME_SERIE+ " DESC";
        return db.query(EpisodioContract.Lembrete.TABLE_NAME, visao,restricoes,params,null,null, sort);
    }
}
