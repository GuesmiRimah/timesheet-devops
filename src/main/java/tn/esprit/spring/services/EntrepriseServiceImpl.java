package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entrepriseRepository;
	private static final Logger L = LogManager.getLogger(EntrepriseServiceImpl.class);

	 
	
	@Override
	public List<Entreprise> retrieveAllEntreprises() { 
		List<Entreprise> entreprises = null; 
		try {
	
			
			L.info("In Method retrieveAllEntreprises :");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();  
			for (Entreprise entreprise : entreprises) {
				L.debug("connexion à la DB OK :");
				  
			} 
			L.info("Out of Method retrieveAllEntreprises with Sucess");
		}catch (Exception e) {
			L.error("Out of Method retrieveAllEntreprises with Erroes : " +e);
		}

		return entreprises;
	}


	@Override
	public Entreprise addEntreprise(Entreprise e) {
		
		L.info("In Method addEntreprise :");
		Entreprise e_saved = entrepriseRepository.save(e); 
		L.info("Out of Method addEntreprise with Sucess"); 
		return e_saved; 
	}

	@Override 
	public Entreprise updateEntreprise(Entreprise e) { 
		L.info("In Method updateEntreprise :"); 
		Entreprise e_saved = entrepriseRepository.save(e); 
		L.info("Out of Method updateEntreprise with Sucess"); 
		return e_saved; 
	}

	@Override
	public void deleteEntreprise(int  id) {
		L.info("In Method deleteEntreprise :"); 
		entrepriseRepository.deleteById(id); 
		L.info("Out of Method deleteEntreprise with Sucess");  
	}

	@Override
	public Entreprise retrieveEntreprise(int id) {
		return entrepriseRepository.findById(id).get();
		  
	}

}
