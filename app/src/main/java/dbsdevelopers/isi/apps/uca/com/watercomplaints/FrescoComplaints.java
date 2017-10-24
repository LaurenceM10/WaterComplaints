package dbsdevelopers.isi.apps.uca.com.watercomplaints;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by macyarin on 11/10/17.
 */

public class FrescoComplaints extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
