package com.programacion.ecommerce;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@ApplicationScoped
@DeclareRoles({ "user" })
public class SalesModuleApplication extends Application {

}
