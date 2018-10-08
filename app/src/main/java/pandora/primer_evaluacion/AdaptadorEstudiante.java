package pandora.primer_evaluacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorEstudiante extends ArrayAdapter<Estudiante> {

    public AdaptadorEstudiante(Context context, List<Estudiante> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Estudiante estudiante = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_estudiante, parent, false);
        }
        TextView lblNombre = convertView.findViewById(R.id.lblNombre);
        TextView lblCodigo = convertView.findViewById(R.id.lblCodigo);
        TextView lblMateria = convertView.findViewById(R.id.lblMateria);
        TextView lblPromedio = convertView.findViewById(R.id.lblPromedio);
        lblNombre.setText(estudiante.nombre);
        lblCodigo.setText(estudiante.codigo);
        lblMateria.setText(estudiante.materia);
        lblPromedio.setText(estudiante.promedio.toString());
        return convertView;
    }
}