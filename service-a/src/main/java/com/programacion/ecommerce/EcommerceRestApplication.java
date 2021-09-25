package com.programacion.ecommerce;


import com.programacion.ecommerce.config.ConfigTestController;




import com.programacion.ecommerce.secure.TestSecureController;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@ApplicationPath("/data")
@ApplicationScoped
public class EcommerceRestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();

        // resources
        classes.add(HelloController.class);
        
        classes.add(ConfigTestController.class);
        
        
        
        
        
        classes.add(TestSecureController.class);
        
        return classes;
    }
}
