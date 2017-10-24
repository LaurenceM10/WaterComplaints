package dbsdevelopers.isi.apps.uca.com.watercomplaints.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dbsdevelopers.isi.apps.uca.com.watercomplaints.R;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.adapters.AdapterComplaints;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.adapters.AdapterMyComplaints;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.api.Api;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.models.Category;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.models.Denuncia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComplaintsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Category> denuncias;

    public ComplaintsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complaints, container, false);

        init(view);
        return view;
    }

    public void init(View view){
        recyclerView = view.findViewById(R.id.recycler_view_complaints);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //Call from API
        Log.i("OK Llegué", "HOLA mundo");

        Call<List<Category>> call = Api.instance().getCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if(response.body() != null){
                    AdapterComplaints adapter = new AdapterComplaints(response.body());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }




}
