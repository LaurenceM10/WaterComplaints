package dbsdevelopers.isi.apps.uca.com.watercomplaints.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import dbsdevelopers.isi.apps.uca.com.watercomplaints.R;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.models.Category;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.models.Denuncia;

/**
 * Created by macyarin on 11/10/17.
 */

public class AdapterComplaints extends RecyclerView.Adapter<AdapterComplaints.ViewHolder> {
    private List<Category> complaints;

    public AdapterComplaints(List<Category> complaints){
        this.complaints = complaints;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleCategory;
        public SimpleDraweeView image;

        public ViewHolder(View view) {
            super(view);
            titleCategory = view.findViewById(R.id.title_category);
            image = view.findViewById(R.id.pic_category);
        }
    }

    @Override
    public AdapterComplaints.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_card, parent, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category c = complaints.get(position);
        holder.titleCategory.setText(complaints.get(position).getName());
        holder.image.setImageURI(complaints.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return complaints.size();
    }
}
