package com.example.parcialmariovega;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ProgressDialog progress;
    private EditText user,contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MARIO & VEGA");
        user=(EditText)findViewById(R.id.edittex_usuario);
        contra=(EditText)findViewById(R.id.edittex_contraseña);
    }
    public void entrar(View view) {
        login();

    }
    public  void progresd(){

        progress = new ProgressDialog( MainActivity.this);
        progress.setTitle("Por favor espere");
        progress.setMessage("Cargando..........");
        progress.show();
        progress.setCancelable(false);

    }

    private void  login(){

        if (!user.getText().toString().trim().isEmpty() && !contra.getText().toString().trim().isEmpty()){

            ejecutarLoginTask ejecutarLoginTask = new ejecutarLoginTask();
            ejecutarLoginTask.execute();
        }else{

            Toast notificacion = Toast.makeText(this,"Ingresar todos los datos (usuario y contraseña)",Toast.LENGTH_LONG);
            notificacion.show();



        }

    }

    private void iniciar(){
        if (user.getText().toString().trim().equalsIgnoreCase("student") && contra.getText().toString().trim().equalsIgnoreCase("12345")){

            Intent inicio = new Intent( MainActivity.this, SegundaActivity.class);
            startActivity(inicio);
            finish();

        }else{
            Toast notificacion = Toast.makeText(this,"Datos incorrectos (usuario ó contraseña)",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }




    class  ejecutarLoginTask extends AsyncTask<String, Void , String> {

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
                return  "Terminado";
            }catch (InterruptedException e){
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

            progress.dismiss();
            iniciar();

        }
    }


}