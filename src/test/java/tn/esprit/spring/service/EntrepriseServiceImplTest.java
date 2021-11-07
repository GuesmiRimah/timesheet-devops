package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEntrepriseService;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService es;

	
	public void testRetrieveAllEntreprises() {
	List<Entreprise> listEntreprises = es.retrieveAllEntreprises();
	Assertions.assertEquals(0, listEntreprises.size());
	}
	
	
	public void testAddEntreprise() throws ParseException, java.text.ParseException {
		Entreprise e = new Entreprise ("Renault", "SAS");
		Entreprise entrepriseAdded = es.addEntreprise(e);
		Assertions.assertEquals(e.getId(), entrepriseAdded.getId());
	}
		
	
	public void testUpdateEntreprise() throws ParseException {
		Entreprise e = new Entreprise ("Cloud kicks", "Informations");
		Entreprise entrepriseUpdated = es.addEntreprise(e);
		Assertions.assertEquals(e.getId(), entrepriseUpdated.getId());
		
		
	}
	
	//public void testDeleteEntreprise(){
		//es.deleteEntreprise(3);
		//Assertions.assertNull(es.retrieveEntreprise(5));
		
	//}	
	
	private static final Logger L = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	@Test
	public void testAll(){
		try{
			L.info("In testAll()");
			testRetrieveAllEntreprises();
			testAddEntreprise();
			testUpdateEntreprise();
			//testDeleteEntreprise();
			L.info("Out of testAll()");
		}catch(Exception e){
			L.error("Out of testAll()with error:" +e);
		}
		
	}
	

}

