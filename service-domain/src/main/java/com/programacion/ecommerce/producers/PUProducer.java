package com.programacion.ecommerce.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PUProducer {
	@Produces
	@Default
	@ApplicationScoped
	public EntityManagerFactory create() {
		return Persistence.createEntityManagerFactory("ecommerce");
	}

	public void destroy(@Disposes EntityManagerFactory factory) {
		factory.close();
	}
}
