package com.ameni.medicaments.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Medicament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedicament;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomMedicament;
	
	@Min(value = 1)
	@Max(value = 10000)
	private Double prixMedicament;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateVente;
	
	@ManyToOne
	private Categorie categorie ;
	
	public Medicament() {
		super();
	}


	public Long getIdMedicament() {
		return idMedicament;
	}


	public void setIdMedicament(Long idMedicament) {
		this.idMedicament = idMedicament;
	}


	public String getNomMedicament() {
		return nomMedicament;
	}


	public void setNomMedicament(String nomMedicament) {
		this.nomMedicament = nomMedicament;
	}


	public Double getPrixMedicament() {
		return prixMedicament;
	}


	public void setPrixMedicament(Double prixMedicament) {
		this.prixMedicament = prixMedicament;
	}


	public Date getDateVente() {
		return dateVente;
	}


	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}


	public Medicament( String nomMedicament, Double prixMedicament, Date dateVente) {
		super();
		
		this.nomMedicament = nomMedicament;
		this.prixMedicament = prixMedicament;
		this.dateVente = dateVente;
	}


	@Override
	public String toString() {
		return "Medicament [idMedicament=" + idMedicament + ", nomMedicament=" + nomMedicament + ", prixMedicament="
				+ prixMedicament + ", dateVente=" + dateVente + "]";
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	

}
