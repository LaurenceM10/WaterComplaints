package dbsdevelopers.isi.apps.uca.com.watercomplaints.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import dbsdevelopers.isi.apps.uca.com.watercomplaints.R;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.models.Denuncia;

/**
 * Created by macyarin on 11/10/17.
 */



public class AdapterMyComplaints extends  RecyclerView.Adapter<AdapterMyComplaints.ViewHolder>{
    private List<Denuncia> complaints;

    public AdapterMyComplaints(List<Denuncia> complaints) {
        this.complaints = complaints;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleComplaint;
        public TextView descriptionComplaint;
        public SimpleDraweeView image;

        public ViewHolder(View view){
            super(view);
            titleComplaint = view.findViewById(R.id.title_complaint);
            descriptionComplaint =  view.findViewById(R.id.description_complaint);
            image = view.findViewById(R.id.pic_complaint);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.complaints_card_view, parent, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Denuncia Complaint = complaints.get(position);
        holder.titleComplaint.setText(complaints.get(position).getTitle());
        holder.descriptionComplaint.setText(complaints.get(position).getDescription());
        holder.image.setImageURI(complaints.get(position).getPicture());
    }

    @Override
    public int getItemCount() {
        return complaints.size();
    }
}
