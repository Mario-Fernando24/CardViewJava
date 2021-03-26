package com.example.parcialmariovega;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SegundaActivity extends AppCompatActivity {

    private RecyclerView recyclerViewproductos;
    private RecyclerViewAdaptador adaptadorProducto;
    private ProgressDialog progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        setTitle("Bienvenidos, 1 Parcial");

        recyclerViewproductos = (RecyclerView) findViewById(R.id.listaRecview);
        recyclerViewproductos.setLayoutManager(new LinearLayoutManager(this));



        adaptadorProducto = new RecyclerViewAdaptador(ObtenerProducto());

        recyclerViewproductos.setAdapter(adaptadorProducto);
        TasKCargar tasKCargar = new TasKCargar();
        tasKCargar.execute();

    }


    public List<Productos> ObtenerProducto() {

        List<Productos> producto = new ArrayList<>();
        producto.add(new Productos("", "", R.mipmap.ic_launcher_round));
        producto.add(new Productos("", "", R.mipmap.ic_launcher_round));
        producto.add(new Productos("", "", R.mipmap.ic_launcher_round));
        producto.add(new Productos("", "", R.mipmap.ic_launcher_round));
        producto.add(new Productos("", "", R.mipmap.ic_launcher_round));


        return producto;
    }

    public  void progresd(){

        progress = new ProgressDialog( SegundaActivity.this);
        progress.setTitle("Por favor espere");
        progress.setMessage("Cargando..........");
        progress.show();
        progress.setCancelable(false);

    }

    class TasKCargar extends AsyncTask<String, Void, String> {
        private ProgressDialog progress;

        @Override
        // se visualiza  la barra de estado al momento de autenticar al usuario.
        protected void onPreExecute() {
            progresd();
        }

        @Override
        // hilo en segundo plano , se ejecutan un proceso en segundo plano
        // simula la esperada del  login.
        // retarda 3 segundos al acceso a la segunda activity.
        protected String doInBackground(String... strings) {
            try {

                Thread.sleep(3000);
                return "Terminado";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "Error";
            }
        }

        @Override
        //termnado el proceso en doInBackground
        // aca los elementos se colocan en estado invisible( la barra)
        // y se vuelve activar el boton Entar y se llama al metodo login() para hacer las comparaciones
        // para dar paso a la segunda activity.
        protected void onPostExecute(String mensaje) {


        }
    }


}

