package pandora.primer_evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoEstudiante extends AppCompatActivity {
    private EditText txtNombre,txtCodigo,txtMateria,txtParcial1,txtParcial2,txtParcial3;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_estudiante);

        txtNombre   = findViewById(R.id.txtNombre);
        txtCodigo   = findViewById(R.id.txtCodigo);
        txtMateria   = findViewById(R.id.txtMateria);
        txtParcial1   = findViewById(R.id.txtParcial1);
        txtParcial2   = findViewById(R.id.txtParcial2);
        txtParcial3   = findViewById(R.id.txtParcial3);
        btnGuardar  = (Button  ) findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNombre.getText().toString().isEmpty() || txtCodigo.getText().toString().isEmpty() ||
                    txtMateria.getText().toString().isEmpty() || txtParcial1.getText().toString().isEmpty() ||
                    txtParcial2.getText().toString().isEmpty() || txtParcial3.getText().toString().isEmpty()){
                    Toast.makeText(NuevoEstudiante.this,"Inserta los datos del estudiante",Toast.LENGTH_SHORT).show();
                }else{
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("Nombre",txtNombre.getText().toString());
                    resultIntent.putExtra("Codigo",txtCodigo.getText().toString());
                    resultIntent.putExtra("Materia",txtMateria.getText().toString());
                    resultIntent.putExtra("Parcial1",txtParcial1.getText().toString());
                    resultIntent.putExtra("Parcial2",txtParcial2.getText().toString());
                    resultIntent.putExtra("Parcial3",txtParcial3.getText().toString());
                    setResult(Principal.RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}
