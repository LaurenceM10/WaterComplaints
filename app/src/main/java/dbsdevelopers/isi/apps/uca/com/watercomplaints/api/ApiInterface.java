package dbsdevelopers.isi.apps.uca.com.watercomplaints.api;

import java.util.List;
import java.util.Locale;

import dbsdevelopers.isi.apps.uca.com.watercomplaints.models.Category;
import dbsdevelopers.isi.apps.uca.com.watercomplaints.models.Denuncia;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by isi3 on 17/4/2017.
 */

public interface ApiInterface {

    @GET("Categories")
    Call<List<Category>> getCategories();

    @GET("Complaints")
    Call<List<Denuncia>> getDenuncias();

    @GET("Complaints")
    Call<Denuncia> createComplaint(@Body Denuncia denuncia);
}