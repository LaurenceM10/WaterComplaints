package dbsdevelopers.isi.apps.uca.com.watercomplaints.models;

import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by macyarin on 11/10/17.
 */

public class Denuncia {
    private String title;
    private String description;
    private int categoryId;
    private int userId;
    private double longitud;
    private String picture;
    private boolean enabled;

    public Denuncia(String title, String description, String picture){
        this.title = title;
        this.description = description;
        this.picture = picture;
    }

    public Denuncia(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
