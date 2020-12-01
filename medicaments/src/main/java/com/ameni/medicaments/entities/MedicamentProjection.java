package com.ameni.medicaments.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProd", types = { Medicament.class })
public interface MedicamentProjection {
	
	public String getNomMedicament();

}
