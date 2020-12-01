package com.ameni.medicaments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ameni.medicaments.entities.Categorie;
import com.ameni.medicaments.entities.Medicament;
import com.ameni.medicaments.repos.MedicamentRepository;

@Service
public class MedicamentServiceImpl implements MedicamentService {

	@Autowired
	MedicamentRepository medicamentRepository ;
	
	
	@Override
	public Medicament saveMedicament(Medicament m) {
		return medicamentRepository.save(m);
	}

	@Override
	public Medicament updateMedicament(Medicament m) {
		return medicamentRepository.save(m);
	}

	@Override
	public void deleteMedicament(Medicament m) {
		medicamentRepository.delete(m);
	}

	@Override
	public void deletMedicamentById(Long id) {
		medicamentRepository.deleteById(id);
	}

	@Override
	public Medicament getMedicament(Long id) {
		return medicamentRepository.findById(id).get();
	}

	@Override
	public List<Medicament> getAllMedicaments() {
		return medicamentRepository.findAll();
	}

	@Override
	public Page<Medicament> getAllMedicamentsParPage(int page, int size) {
		return medicamentRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Medicament> findByNomMedicament(String nom) {
		return medicamentRepository.findByNomMedicament(nom);
	}
	
	@Override
	public List<Medicament> findByNomMedicamentContains(String nom) {
		return medicamentRepository.findByNomMedicamentContains(nom);
	}
	
	@Override
	public List<Medicament> findByNomPrix(String nom, Double prix) {
		return medicamentRepository.findByNomPrix(nom, prix);
	}
	
	@Override
	public List<Medicament> findByCategorie(Categorie categorie) {
		return medicamentRepository.findByCategorie(categorie);
	}
	
	@Override
	public List<Medicament> findByCategorieIdCat(Long id) {
		return medicamentRepository.findByCategorieIdCat(id);
	}
	
	@Override
	public List<Medicament> findByOrderByNomMedicamentAsc() {
		return medicamentRepository.findByOrderByNomMedicamentAsc();
	}
	
	@Override
	public List<Medicament> trierMedicamentsNomsPrix() {
		return medicamentRepository.trierMedicamentsNomsPrix();
	}
}
