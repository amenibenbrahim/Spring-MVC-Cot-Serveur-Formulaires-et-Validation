package com.ameni.medicaments.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ameni.medicaments.entities.Categorie;
import com.ameni.medicaments.entities.Medicament;

@RepositoryRestResource(path = "rest")
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
	
	List<Medicament> findByNomMedicament(String nom);
	List<Medicament> findByNomMedicamentContains(String nom);
	
	//@Query("select m from Medicament m where m.nomMedicament like %?1 and m.prixMedicament > ?2")
	//List<Medicament> findByNomPrix (String nom, Double prix);
	
	@Query("select m from Medicament m where m.nomMedicament like %:nom and m.prixMedicament > :prix")
	List<Medicament> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	@Query("select m from Medicament m where m.categorie = ?1")
	List<Medicament> findByCategorie (Categorie categorie);
	
	List<Medicament> findByCategorieIdCat(Long id);
	
	List<Medicament> findByOrderByNomMedicamentAsc();
	
	@Query("select m from Medicament m order by m.nomMedicament ASC, m.prixMedicament DESC")
	List<Medicament> trierMedicamentsNomsPrix ();
	
}
