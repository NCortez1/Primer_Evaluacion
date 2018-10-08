package pandora.primer_evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaEstudiantes extends AppCompatActivity {
    private ArrayList<Estudiante> estudiantesArrayList;
    private AdaptadorEstudiante adaptadorEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);

        estudiantesArrayList = Principal.estudiantesArrayList;
        adaptadorEstudiante = new AdaptadorEstudiante(this,  estudiantesArrayList);
        ListView listView = findViewById(R.id.lstEstudiantes);
        listView.setAdapter(adaptadorEstudiante);
    }
}
