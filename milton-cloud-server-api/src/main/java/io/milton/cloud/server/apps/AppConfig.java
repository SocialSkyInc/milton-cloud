package io.milton.cloud.server.apps;

import io.milton.context.Context;
import java.util.Properties;

/**
 *
 * @author brad
 */
public class AppConfig {

    private Properties properties;
    private Context context;

    public AppConfig(Properties properties, Context context) {
        this.properties = properties;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
            
    
    public Integer getInt(String name) {
        String s = properties.getProperty(name);
        if (s == null) {
            return null;
        } else {
            return Integer.parseInt(s);
        }
    }
    
    public void setInt(String name, Integer value) {
        if( value == null ) {
            properties.remove(name);
        } else {
            properties.setProperty(name, value.toString());
        }
    }
    
    public void add(String name, String val) {
        properties.put(name, val);
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
