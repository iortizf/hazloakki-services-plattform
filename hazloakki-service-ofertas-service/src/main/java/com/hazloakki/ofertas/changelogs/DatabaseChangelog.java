package com.hazloakki.ofertas.changelogs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.hazloakki.ofertas.modelo.Catalogo;
import com.hazloakki.ofertas.modelo.Elemento;

@ChangeLog
public class DatabaseChangelog {
  
  @ChangeSet(order = "001", id = "cargarCatalogos", author = "Israel")
  public void someChange5(MongoTemplate mongoTemplate) {
	mongoTemplate.createCollection("catalogo");
	
	Catalogo catalogoEstatus = new Catalogo();
	catalogoEstatus.setIdCatalogo(1);
	catalogoEstatus.setNombre("Estatus");
	catalogoEstatus.setDescripcion("Establece todos los estatus que maneja un oferta");
	
	Elemento creado = new Elemento(1,"Creado", "Se creo una oferta");
	Elemento cancelado = new Elemento(2, "Cancelado", "Una oferta se cancelo");
	Elemento eliminado = new Elemento(3, "Eliminado", "Eliminaron una oferta");
	Elemento publicado = new Elemento(4, "Publicado", "Se publica una oferta");
	
	List<Elemento> elementosEstatus = new ArrayList<>();
	elementosEstatus.add(creado);
	elementosEstatus.add(cancelado);
	elementosEstatus.add(eliminado);
	elementosEstatus.add(publicado);	
	catalogoEstatus.setElementos(elementosEstatus);
	
	Catalogo catalogoRecordatorio = new Catalogo();
	catalogoRecordatorio.setIdCatalogo(2);
	catalogoRecordatorio.setNombre("Recordatorios");
	catalogoRecordatorio.setDescripcion("Define el tiempo para recordar el inicio/fin de una oferta");
	
	Elemento zero = new Elemento(0, "Ninguno", "No hay recordatorio");
	Elemento cincoMin = new Elemento(1, "5 min. antes", "Notificar 5 minutos antes de lanzar la oferta");
	Elemento diezMin = new Elemento(2, "10 min. antes", "Notificar 10 minutos antes de lanzar la oferta");
	Elemento veinteMin = new Elemento(3, "20 min. antes", "Notificar 20 minutos antes de lanzar la oferta");
	
	List<Elemento> elementosRecord = new ArrayList<>();
	elementosRecord.add(zero);
	elementosRecord.add(cincoMin);
	elementosRecord.add(diezMin);
	elementosRecord.add(veinteMin);
	
	catalogoRecordatorio.setElementos(elementosRecord);
		
	Catalogo catalogoAlerta = new Catalogo();
	catalogoAlerta.setIdCatalogo(3);
	catalogoAlerta.setNombre("Alertas");
	catalogoAlerta.setDescripcion("Establece los diferentes medios de notificacion");
	
	Elemento ninguno = new Elemento(0, "Ninguno", "Sin notificacion");
	Elemento noti = new Elemento(1, "Notificacion", "Push notification");
	Elemento sms = new Elemento(2, "SMS", "SMS");
	Elemento correo = new Elemento(3, "Correo", "Por correo electronico");
	
	List<Elemento> elementosAlerta = new ArrayList<>();
	elementosAlerta.add(ninguno);
	elementosAlerta.add(noti);
	elementosAlerta.add(sms);
	elementosAlerta.add(correo);
	
	catalogoAlerta.setElementos(elementosAlerta);
	
	
	Catalogo catalogoTemp = new Catalogo();
	catalogoTemp.setIdCatalogo(4);
	catalogoTemp.setNombre("Temperaturas");
	catalogoTemp.setDescripcion("Establece temperatura de las ofertas");
	
	Elemento normal = new Elemento(0, "Normal", "Normal");
	Elemento hot = new Elemento(1, "Hot", "Buena oferta");
	Elemento superHot = new Elemento(2, "Super hot", "Es una super oferta");
	
	List<Elemento> elementosTemp = new ArrayList<>();
	elementosTemp.add(normal);
	elementosTemp.add(hot);
	elementosTemp.add(superHot);
	
	catalogoTemp.setElementos(elementosTemp);

    mongoTemplate.save(catalogoEstatus);
    mongoTemplate.save(catalogoRecordatorio);
    mongoTemplate.save(catalogoAlerta);
    mongoTemplate.save(catalogoTemp);
  }


}