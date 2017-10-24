package dbsdevelopers.isi.apps.uca.com.watercomplaints.models;

/**
 * Created by Administrador on 13/10/2017.
 */

public class Category {
    private String name;
    private String icon;
    private boolean enabled;

    public Category(String name, String icon, boolean enabled) {
        this.name = name;
        this.icon = icon;
        this.enabled = enabled;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
