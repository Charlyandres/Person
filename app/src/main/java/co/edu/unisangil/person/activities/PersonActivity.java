package co.edu.unisangil.person.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.LinkedList;

import co.edu.unisangil.person.R;
import co.edu.unisangil.person.adapters.PersonAdapter;
import co.edu.unisangil.person.data.ApiDummyJsonClient;
import co.edu.unisangil.person.model.PersonModel;
import co.edu.unisangil.person.model.ResponseApi;
import co.edu.unisangil.person.services.ApiDummyjson;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class PersonActivity extends AppCompatActivity {

    RecyclerView rvPerson;

    PersonAdapter personAdapter;

    LinkedList<PersonModel> person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
    }



    private LinkedList<PersonModel> obtenerPerson(){
        person = new LinkedList<>();
        ApiDummyjson api = ApiDummyJsonClient.getClient().create(ApiDummyjson.class);
        Call<ResponseApi> call = api.getAllPerson();

        call.enqueue(new Callback<ResponseApi>() {
            @Override
            public void onResponse(Call<ResponseApi> call, Response<ResponseApi> response) {
                if(response.isSuccessful()){
                    personAdapter = new PersonAdapter(response.body().getPerson());
                    rvPerson.setAdapter(personAdapter);
                }else{
                    Toast.makeText(PersonActivity.this, "Error de usuario", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseApi> call, Throwable t) {
                Toast.makeText(PersonActivity.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
            }
        });
        return person;
    }
}