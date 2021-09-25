package com.programacion.ecommerce;


import com.programacion.ecommerce.secure.ProtectedController;
import org.eclipse.microprofile.auth.LoginConfig;
import javax.annotation.security.DeclareRoles;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@ApplicationPath("/data")

@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"protected"})

@ApplicationScoped
public class EcommerceRestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();

        // resources
        
        
        classes.add(ProtectedController.class);
        

        return classes;
    }
}
