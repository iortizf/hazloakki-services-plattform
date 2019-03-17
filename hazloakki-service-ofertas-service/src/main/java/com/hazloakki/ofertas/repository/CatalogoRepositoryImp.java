package com.hazloakki.ofertas.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.hazloakki.ofertas.modelo.Catalogo;

@Repository
public class CatalogoRepositoryImp implements CatalogoRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void guardar(Catalogo catalogo) {
		mongoTemplate.save(catalogo);
	}

	@Override
	public Catalogo obtenerById(Integer idCatalogo) {
		return mongoTemplate.findById(idCatalogo, Catalogo.class);
	}

}
