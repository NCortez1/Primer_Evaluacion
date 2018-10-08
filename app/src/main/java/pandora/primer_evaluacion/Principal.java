package pandora.primer_evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {
    public static ArrayList<Estudiante> estudiantesArrayList;
    private Button btnNuevo;
    private Button btnLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        estudiantesArrayList = new ArrayList<>();
        this.btnNuevo = findViewById(R.id.btnNuevo);
        this.btnLista = findViewById(R.id.btnLista);

        this.btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevoEstudiante = new Intent(Principal.this,NuevoEstudiante.class);
                startActivityForResult(nuevoEstudiante,1);
            }
        });
        this.btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listaEstudiantes = new Intent(Principal.this,ListaEstudiantes.class);
                startActivity(listaEstudiantes);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Estudiante est = new Estudiante(
                        data.getStringExtra("Nombre"),
                        data.getStringExtra("Codigo"),
                        data.getStringExtra("Materia"),
                        Double.parseDouble(data.getStringExtra("Parcial1")),
                        Double.parseDouble(data.getStringExtra("Parcial2")),
                        Double.parseDouble(data.getStringExtra("Parcial3")));
                estudiantesArrayList.add(est);
            }
        }
    }
}
