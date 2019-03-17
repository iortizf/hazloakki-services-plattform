package com.hazloakki.ofertas.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hazloakki.ofertas.modelo.Configuracion;
import com.hazloakki.ofertas.modelo.Oferta;

@Repository
public class OfertaRepositoryImp implements OfertaRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Oferta guardar(Oferta nuevaOferta) {
		mongoTemplate.save(nuevaOferta);
		return nuevaOferta;
	}

	@Override
	public List<Oferta> obtenerByIdNegocio(String idNegocio) {
		Query query = new Query();
		query.addCriteria(Criteria.where("idNegocio").is(idNegocio));
		return mongoTemplate.find(query, Oferta.class);
	}

	@Override
	public void modificar(Oferta oferta) {
		mongoTemplate.save(oferta);
	}
	

	@Override
	public void eliminar(String id) {
		Oferta ofertaToDelete = mongoTemplate.findById(id, Oferta.class);
		if(ofertaToDelete!=null)
			mongoTemplate.remove(ofertaToDelete);
	}

	@Override
	public Oferta obtenerById(String id) {
		return mongoTemplate.findById(id, Oferta.class);
	}

	@Override
	public Configuracion obtenerConfig(String id) {
		Oferta oferta = mongoTemplate.findById(id, Oferta.class);
		if(oferta!=null)
			return oferta.getConfig();
			
		return null;
	}

	@Override
	public Configuracion guardarConfig(String id, Configuracion config) {
		Oferta oferta = mongoTemplate.findById(id, Oferta.class);
		if(oferta!=null) {
			oferta.setConfig(config);
			mongoTemplate.save(oferta);
			return oferta.getConfig();
		}
		
		return null;
	}

}
