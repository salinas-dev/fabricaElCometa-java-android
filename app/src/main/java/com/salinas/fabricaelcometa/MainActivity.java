package com.salinas.fabricaelcometa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.salinas.fabricaelcometa.model.fabricaCometaModel;

public class MainActivity extends AppCompatActivity {

    Spinner cmbClaves;
    TextInputEditText txtCostoMateriaPrima;
    Button btnCalcular;
    Button btnNuevo;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        String opcionClaves[] = {"--SELECCIONE CLAVE--", "Clave 1", "Clave 2", "Clave 3", "Clave 4", "Clave 5","Clave 6"};
        cmbClaves = findViewById(R.id.spClaves);
        txtCostoMateriaPrima=findViewById(R.id.txCostoMateriaPrima);
        btnCalcular = findViewById(R.id.buttonCalcular);
        btnNuevo = findViewById(R.id.buttonNuevo);
        btnSalir = findViewById(R.id.buttonSalir);

        ArrayAdapter<String> adapClave = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, opcionClaves);

        cmbClaves.setAdapter(adapClave);

        //Listener para calcular el costo del automovil
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    int noClave;
                    int matPrim;

                    noClave = cmbClaves.getSelectedItemPosition();
                    matPrim = Integer.parseInt(txtCostoMateriaPrima.getText().toString());

                    if (cmbClaves.getSelectedItemPosition() == 0 ){
                        Toast.makeText(getApplicationContext(), "--Seleccione una Clave de Articulos-", Toast.LENGTH_LONG).show();
                    }else if(txtCostoMateriaPrima.length() == 0) {
                        txtCostoMateriaPrima.setError("Debe Ingresar la Cantidad");
                        txtCostoMateriaPrima.requestFocus();
                    }

                    //Creamos el objeto de la clase modelo para extraer sus metodos
                    fabricaCometaModel obj = new fabricaCometaModel();
                    obj.setClave(noClave);
                    obj.setMateriaPrima(matPrim);

                    Toast.makeText(getApplicationContext(), obj.calcularPrecioVenta(), Toast.LENGTH_SHORT).show();

                }catch(Exception e){

                    //txtCostoMateriaPrima.setError("Debe Ingresar la Cantidad");
                    //txtCostoMateriaPrima.requestFocus();

                }

                //Listener para salir de la app
                btnSalir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });


                btnNuevo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cmbClaves.setAdapter(null);
                        txtCostoMateriaPrima.setText(null);
                    }
                });

            }
        });
    }
}