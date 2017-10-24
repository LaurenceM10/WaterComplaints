package dbsdevelopers.isi.apps.uca.com.watercomplaints.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dbsdevelopers.isi.apps.uca.com.watercomplaints.R;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.activities.Activity_Complaint_Add;
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
public class MyComplaintsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Denuncia> denuncias;

    public MyComplaintsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_complaints, container, false);
        init(view);
        return view;
    }


    public void init(View view){
        recyclerView = view.findViewById(R.id.recycler_view_my_complaints);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Call<List<Denuncia>> call = Api.instance().getDenuncias();
        call.enqueue(new Callback<List<Denuncia>>() {
            @Override
            public void onResponse(Call<List<Denuncia>> call, Response<List<Denuncia>> response) {
                if(response.body() != null){
                    AdapterMyComplaints denuncias = new AdapterMyComplaints(response.body());
                    recyclerView.setAdapter(denuncias);
                }
            }

            @Override
            public void onFailure(Call<List<Denuncia>> call, Throwable t) {

            }
        });
    }

}
