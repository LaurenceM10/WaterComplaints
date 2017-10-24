package dbsdevelopers.isi.apps.uca.com.watercomplaints.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dbsdevelopers.isi.apps.uca.com.watercomplaints.R;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.api.Api;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.models.Denuncia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Complaint_Add extends AppCompatActivity {
    private EditText title;
    private EditText description;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__complaint__add);

        initViews();
        initActions();;
    }

    private void initViews() {
        title = (EditText) findViewById(R.id.title);
        description = (EditText) findViewById(R.id.description);
        create = (Button) findViewById(R.id.create);
    }

    private void initActions() {
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create();
            }
        });
    }

    private void create(){
        if (title.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Requiero un titulo", Toast.LENGTH_LONG).show();
        } else if(description.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Requiero una descripcion", Toast.LENGTH_LONG).show();
        } else {
            Denuncia complaint = new Denuncia();
            complaint.setTitle(title.getText().toString());
            complaint.setDescription(description.getText().toString());
            complaint.setCategoryId(1);
            complaint.setUserId(1);
            complaint.setEnabled(true);

            Call<Denuncia> call = Api.instance().createComplaint(complaint);
            call.enqueue(new Callback<Denuncia>() {
                @Override
                public void onResponse(Call<Denuncia> call, Response<Denuncia> response) {
                    if (response.body() != null) {
                        Denuncia complaintResult  = response.body();
                        assert complaintResult != null;
                        Log.i("title", complaintResult.getTitle());
                        Log.i("description", complaintResult.getDescription());
                    }
                }

                @Override
                public void onFailure(Call<Denuncia> call, Throwable t) {

                }
            });
        }
    }
}
