package co.edu.unisangil.person.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;

import co.edu.unisangil.person.R;
import co.edu.unisangil.person.activities.VistaActivity;
import co.edu.unisangil.person.model.PersonModel;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    LinkedList<PersonModel> person;

    public PersonAdapter(LinkedList<PersonModel> person) {
        this.person = person;
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonModel persons = person.get(position);
        holder.txtNombre.setText(persons.getNombre());
        holder.txtEdad.setText(String.valueOf(persons.getEdad()));
        holder.txtDireccion.setText(persons.getDireccion());
        Picasso.with(holder.itemView.getContext()).load(persons.getFoto()).into(holder.imgPerson);
    }


    @Override
    public int getItemCount() {
        return person.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPerson;

        TextView txtNombre, txtEdad, txtDireccion;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPerson = itemView.findViewById(R.id.imgPerson);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtEdad = itemView.findViewById(R.id.txtEdad);
            txtDireccion = itemView.findViewById(R.id.txtDireccion);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), VistaActivity.class );
                    intent.putExtra("nombre", txtNombre.getText());
                    intent.putExtra("edad", txtEdad.getText());
                    intent.putExtra("direccion", txtDireccion.getText());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
