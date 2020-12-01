package com.ameni.medicaments;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ameni.medicaments.entities.Categorie;
import com.ameni.medicaments.entities.Medicament;
import com.ameni.medicaments.repos.MedicamentRepository;
import com.ameni.medicaments.service.MedicamentService;

@SpringBootTest
class MedicamentsApplicationTests {

	@Autowired
	private MedicamentRepository medicamentRepository;
	
	@Autowired
	private MedicamentService medicamentService;
	
	@Test
	public void testCreateMedicament() {
		Medicament medc = new Medicament("Panadole",3.500,new Date());
		medicamentRepository.save(medc);
	}
	
	@Test
	public void testFindMedicament()
	{
		Medicament m = medicamentRepository.findById(1L).get();
		System.out.println(m);
	}
	
	@Test
	public void testUpdateMedicament()
	{
		Medicament m = medicamentRepository.findById(1L).get();
		m.setPrixMedicament(4.0);
		medicamentRepository.save(m);
	}

	@Test
	public void testDeleteMedicament(){
		medicamentRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousProduits()
	{
		List<Medicament> medcs = medicamentRepository.findAll();
		for (Medicament m : medcs)
		{
			System.out.println(m);
		}
	}
	
	@Test
	public void testFindByNomMedicamentContains()
	{
		Page<Medicament> medcs = medicamentService.getAllMedicamentsParPage(0,2);
		System.out.println(medcs.getSize());
		System.out.println(medcs.getTotalElements()); 
		System.out.println(medcs.getTotalPages());
		medcs.getContent().forEach(b -> {System.out.println(b.toString());
	});
	}
	
	@Test
	public void testFindMedicamentByNom()
	{
		List<Medicament> mdcs = medicamentRepository.findByNomMedicament("Panadole");
		for (Medicament m : mdcs)
		{
			System.out.println(m);
		}
	}
	
	@Test
	public void testFindMedicamentByNomContains()
	{
		List<Medicament> mdcs = medicamentRepository.findByNomMedicamentContains("P");
		for (Medicament m : mdcs)
		{
			System.out.println(m);
		}
	}
	
	@Test
	public void testfindByNomPrix()
	{
		List<Medicament> medcs = medicamentRepository.findByNomPrix("Panadole", 2.600);
		for (Medicament m : medcs)
			System.out.println(m);
	}
	
	@Test
	public void testfindByCategorie()
	{
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Medicament> medcs = medicamentRepository.findByCategorie(cat);
		for (Medicament m : medcs)
		{
			System.out.println(m);
			}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
		List<Medicament> medcs = medicamentRepository.findByCategorieIdCat(1L);
		for (Medicament m : medcs)
		{
			System.out.println(m);
			}
	}
	
	@Test
	public void testfindByOrderByNomMedicamentAsc()
	{
		List<Medicament> medcs =
				medicamentRepository.findByOrderByNomMedicamentAsc();
		for (Medicament m : medcs)
		{
			System.out.println(m);
			}
		}
	
	@Test
	public void testTrierMedicamentsNomsPrix()
	{
		List<Medicament> medcs = medicamentRepository.trierMedicamentsNomsPrix();
		for (Medicament m : medcs)
		{
			System.out.println(m);
			}
	}
	

	
}
